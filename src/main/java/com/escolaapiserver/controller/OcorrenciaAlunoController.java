package com.escolaapiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolaapiserver.document.Ocorrencia;
import com.escolaapiserver.dto.OcorrenciasDTO;
import com.escolaapiserver.services.AlunoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/aluno/ocorrencia")
public class OcorrenciaAlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/{id}")
	private Mono<OcorrenciasDTO> getOcorrencias(@PathVariable("id") String id) {
		return alunoService.findByOcorrencias(id)
				.map(alunoOcorrencias -> new OcorrenciasDTO(alunoOcorrencias))
				.switchIfEmpty(Mono.error(new Exception("Não existe(m) ocorrência(s) para este aluno")));
	}
	
	@PutMapping("/{id}")
	private Mono<OcorrenciasDTO> addOcorrencia(@PathVariable("id") String id, @RequestBody Ocorrencia ocorrencia) {
		
		return alunoService.adicionarOcorrencia(id, ocorrencia)
				.map(alunoOcorrencias -> new OcorrenciasDTO(alunoOcorrencias))
				.switchIfEmpty(Mono.error(new Exception("Erro ao incluir ocorrência")));
		
	}

}
