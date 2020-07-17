package com.escolaapiserver.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Aluno {

	@Id
	private String id;
	@NotNull
	private String matricula;
	private String nome;
	private String telefone;
	private String patente;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Field("data_nascimento")
	private Date dataNascimento;
	private Classe classe;
	private Comportamento comportamento;
	@Indexed(direction = IndexDirection.DESCENDING)
	private List<Ocorrencia> ocorrencias;
	private String situacao;

	public Aluno() {
		this.ocorrencias = new ArrayList<>();
	}

	public Aluno(String matricula, String nome, String telefone, String patente, Classe classe, Date dataNascimento,
			Comportamento comportamento, String situacao, List<Ocorrencia> ocorrencias) {
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.patente = patente;
		this.dataNascimento = dataNascimento;
		this.classe = classe;
		this.comportamento = comportamento;
		this.situacao = situacao;
		this.ocorrencias = ocorrencias;
	}

	public String getId() {
		return id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPatente() {
		return patente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Comportamento getComportamento() {
		return comportamento;
	}

	public void setComportamento(Comportamento comportamento) {
		this.comportamento = comportamento;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ocorrencias == null) ? 0 : ocorrencias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;

		if (ocorrencias == null) {
			if (other.ocorrencias != null)
				return false;
		} else if (!ocorrencias.equals(other.ocorrencias))
			return false;

		return true;
	}

}
