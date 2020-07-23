package com.escolaapiserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolaapiserver.document.Aluno;
import com.escolaapiserver.document.Classificacao;
import com.escolaapiserver.document.Comportamento;
import com.escolaapiserver.document.Ocorrencia;
import com.escolaapiserver.document.TabelaComportamento;
import com.escolaapiserver.document.TipoConduta;
import com.escolaapiserver.repository.AlunoRepository;
import com.escolaapiserver.repository.TabelaComportamentoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	TabelaComportamentoRepository tabelaComportamentoRepository;

	@Override
	public Flux<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Mono<Aluno> findById(String id) {
		return alunoRepository.findById(id);
	}

	@Override
	public Flux<Aluno> findBySituacao(String situacao) {
		return alunoRepository.findBySituacao(situacao);
	}

	@Override
	public Mono<Aluno> matriculaExists(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}

	@Override
	public Mono<Aluno> save(Aluno aluno) {
		
		
		if (aluno.getId() == null) { //Para Novos alunos
			Comportamento comportamento = new Comportamento();
			comportamento.setStatus(Classificacao.Bom);
			comportamento.setPontuacao(8);
			
			aluno.setComportamento(comportamento);
		}
		
		
		return alunoRepository.save(aluno);
	}

	@Override
	public Mono<Void> delete(Aluno aluno) {
		return alunoRepository.delete(aluno); //delete Document
	}

	@Override
	public Mono<Aluno> findByOcorrencias(String id) {
		return alunoRepository.findByOcorrencias(id);
	}

	@Override
	public Mono<Aluno> addOcorrencia(String id, Ocorrencia ocorrencia) {

		return alunoRepository.findById(id).flatMap(alunoFound -> {

			List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>(alunoFound.getOcorrencias());
			Optional<Ocorrencia> ocorrenciaExiste = ocorrencias.stream().filter(ocor -> ocor.equals(ocorrencia)).findFirst();

			if (ocorrenciaExiste.isPresent()) {
				return Mono.error(new ArrayIndexOutOfBoundsException("Ocorrência já cadastrada!"));
			}
				
			ocorrencias.add(ocorrencia);
				
			alunoFound.setOcorrencias(ocorrencias);
			
			//recalcular pontuação do comportamento
			Double pontuacaoAtual = alunoFound.getComportamento().getPontuacao();
			
			if (ocorrencia.getConduta().equals(TipoConduta.Negativa)) {
				pontuacaoAtual -= ocorrencia.getValor();
				if (pontuacaoAtual < 0) {
					pontuacaoAtual = 0.00;
				}
			} else {
				pontuacaoAtual += ocorrencia.getValor();
				if (pontuacaoAtual > 10) {
					pontuacaoAtual = 10.00;
				}
			}
			
			final Double novaPontuacao = pontuacaoAtual;
			
			Mono<TabelaComportamento> tabelaComportamento = tabelaComportamentoRepository.findByGrauRange(novaPontuacao);
			return tabelaComportamento.flatMap(tbcomportamento -> {
				Comportamento comportamento = new Comportamento();
				comportamento.setPontuacao(novaPontuacao);
				comportamento.setStatus(tbcomportamento.getClassificacao());
				
				alunoFound.setComportamento(comportamento);
				
				return Mono.just(alunoFound);
			});

			
		}).flatMap(aluno -> alunoRepository.save(aluno));
		 		
	}

}
