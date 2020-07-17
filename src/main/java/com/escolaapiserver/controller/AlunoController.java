package com.escolaapiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolaapiserver.document.Aluno;
import com.escolaapiserver.dto.AlunoDTO;
import com.escolaapiserver.exceptions.AlunoNotFoundException;
import com.escolaapiserver.services.AlunoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public Flux<AlunoDTO> getAlunos() {
	/* Lista de alunos com dados reduzidos pelo AlunoDTO */
		
		return alunoService.findAll()
				.map(aluno -> new AlunoDTO(aluno))
				.switchIfEmpty(Mono.error(new Exception("Nada encontrado!")));
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Aluno>> getById(@PathVariable("id") String id) {
//		System.out.print("lista");
		return alunoService.findById(id)
				.map(aluno -> ResponseEntity.ok(aluno))
				.switchIfEmpty(Mono.error(new AlunoNotFoundException("Aluno não encontrado!")))
		        .defaultIfEmpty(ResponseEntity.notFound().build());
		
		//return users.flatMap(u -> roleRepo.findById(u.getRoleId()).map(r -> new UserDto(u, r)));
		
	}

}
