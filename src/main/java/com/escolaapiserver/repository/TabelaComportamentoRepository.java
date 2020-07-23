package com.escolaapiserver.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.escolaapiserver.document.TabelaComportamento;

import reactor.core.publisher.Mono;

@Repository
public interface TabelaComportamentoRepository extends ReactiveMongoRepository<TabelaComportamento, String> {
   
    @Query("{grauInicial : { $lte: ?0} , grauFinal : {$gte: ?0 } }")	
	Mono<TabelaComportamento> findByGrauRange(double pontuacao);

}
