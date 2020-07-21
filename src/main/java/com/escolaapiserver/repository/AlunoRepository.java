package com.escolaapiserver.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.escolaapiserver.document.Aluno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AlunoRepository extends ReactiveMongoRepository<Aluno, String> {
	
	Mono<Aluno> findByMatricula(String matricula);
	Flux<Aluno> findBySituacao(String situacao);
	@Query("{id:?0}")
	Mono<Aluno> findByOcorrencias(String id);
}
