package com.escolaapiserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolaapiserver.document.Aluno;
import com.escolaapiserver.dto.AlunoDTO;
import com.escolaapiserver.exceptions.AlunoNotFoundException;
import com.escolaapiserver.exceptions.MatriculaExistenteException;
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
	
	//NÃO É NECESSÁRIO ENVIAR O OBJETO COM OS DADOS DA AUDITORIA
	//TAMBÉM NÃO INFORMAR O COMPORTAMENTO, POIS O SISTEMA GERARÁ O PADRÃO
	@PostMapping
	public Mono<ResponseEntity<Aluno>> createAluno(@Valid @RequestBody Aluno aluno) {
		return alunoService.matriculaExists(aluno.getMatricula())
				.hasElement()
				.flatMap(foundAluno -> {
					if (foundAluno) {
						return Mono.error(new MatriculaExistenteException("Matrícula já cadastrada!"));
					} else {
						return alunoService.save(aluno)
								.map(savedAluno -> ResponseEntity.ok(savedAluno))
								.onErrorReturn(ResponseEntity.badRequest().build());
					}
				});
	}
	
	//NÃO É NECESSÁRIO ENVIAR O OBJETO COM OS DADOS DA AUDITORIA
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Aluno>> updateAluno(@Valid @PathVariable String id, @RequestBody Aluno aluno) {
		return alunoService.matriculaExists(aluno.getMatricula())
				.flatMap(foundAluno -> {
					if (foundAluno.getMatricula().equals(aluno.getMatricula()) && !foundAluno.getId().equals(aluno.getId())) {
						return Mono.error(new MatriculaExistenteException("Matrícula já cadastrada"));
						
					} else {
						
						aluno.setCreatedUser(foundAluno.getCreatedUser());
						aluno.setCreatedDate(foundAluno.getCreatedDate());
						
						aluno.setComportamento(foundAluno.getComportamento()); //Somente leitura

						return alunoService.save(aluno)
								.map(savedAluno -> ResponseEntity.ok(savedAluno))
								.onErrorReturn(ResponseEntity.badRequest().build());
					}
				});

	}

}
