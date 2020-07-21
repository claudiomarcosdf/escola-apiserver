package com.escolaapiserver.services;

import com.escolaapiserver.document.Aluno;
import com.escolaapiserver.document.Ocorrencia;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlunoService {
	
	Flux<Aluno> findAll();
	Mono<Aluno> findById(String id);
	Flux<Aluno> findBySituacao(String situacao);
	Mono<Aluno> findByOcorrencias(String id); //Retorna o objeto aluno completo
	Mono<Aluno> matriculaExiste(String matricula);
	
	Mono<Aluno> adicionarOcorrencia(String id, Ocorrencia ocorrencia);
	Mono<Aluno> save(Aluno aluno);
	Mono<Void> delete(Aluno aluno);
}
