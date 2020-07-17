package com.escolaapiserver.dto;

import java.util.Date;

import com.escolaapiserver.document.Aluno;

//Para getAll()
public class AlunoDTO {
	
	private String id;
	private String matricula;
	private String nome;
	private String patente;
	private Date dataNascimento;
	private String ano;
	private String turma;
	private String turno;
	private String serie;
	
	public AlunoDTO(Aluno aluno) {
		this.id = aluno.getId();
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();
		this.patente = aluno.getPatente();
		this.dataNascimento = aluno.getDataNascimento();
		this.ano = aluno.getClasse().getAno();
		this.turma = aluno.getClasse().getTurma();
		this.turno = aluno.getClasse().getTurno();
		this.serie = aluno.getClasse().getSerie();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
}
