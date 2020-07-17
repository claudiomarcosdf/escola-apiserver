package com.escolaapiserver.services;

import com.escolaapiserver.document.Aluno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlunoService {
	
	Flux<Aluno> findAll();
	Mono<Aluno> findById(String id);
	Flux<Aluno> findBySituacao(String situacao);
	Mono<Aluno> matriculaExiste(String matricula);
	
	Mono<Aluno> save(Aluno aluno);
	Mono<Void> delete(Aluno aluno);
}
