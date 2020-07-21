package com.escolaapiserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolaapiserver.document.Aluno;
import com.escolaapiserver.document.Classificacao;
import com.escolaapiserver.document.Comportamento;
import com.escolaapiserver.repository.AlunoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;

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
	public Mono<Aluno> matriculaExiste(String matricula) {
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

}
