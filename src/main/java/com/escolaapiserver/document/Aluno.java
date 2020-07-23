package com.escolaapiserver.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongodb.lang.NonNull;

@Document
@JsonIgnoreProperties({"createdDate", "createdUser", "modifiedUser", "lastModifiedDate"})
public class Aluno {

	@Id
	private String id;
	@NonNull @NotBlank
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
	@CreatedDate
	private Date createdDate;
	@CreatedBy
	private String createdUser;
	@LastModifiedBy
	private String modifiedUser;
	@LastModifiedDate
	private Date lastModifiedDate;	
	

	public Aluno() {
		this.ocorrencias = new ArrayList<>();
	}

	public Aluno(String matricula, String nome, String telefone, String patente, Date dataNascimento,
			Classe classe, Comportamento comportamento, List<Ocorrencia> ocorrencias, String situacao, Date createdDate,
			String createdUser, String modifiedUser, Date lastModifiedDate) {
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.patente = patente;
		this.dataNascimento = dataNascimento;
		this.classe = classe;
		this.comportamento = comportamento;
		this.ocorrencias = ocorrencias;
		this.situacao = situacao;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
		this.lastModifiedDate = lastModifiedDate;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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
