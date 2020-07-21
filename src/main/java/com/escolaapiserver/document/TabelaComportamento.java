package com.escolaapiserver.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="tabela-comportamento")
public class TabelaComportamento {
	
	@Id
	private String Id;
	private Classificacao classificacao;
	@Field("grau_inicial")
	private double grauInicial;
	@Field("grau_final")
	private double grauFinal;
	
	public TabelaComportamento() {
	}

	public TabelaComportamento(Classificacao classificacao, double grauInicial, double grauFinal) {
		this.classificacao = classificacao;
		this.grauInicial = grauInicial;
		this.grauFinal = grauFinal;
	}

	public String getId() {
		return Id;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public double getGrauInicial() {
		return grauInicial;
	}

	public void setGrau_inicial(double grauInicial) {
		this.grauInicial = grauInicial;
	}

	public double getGrau_final() {
		return grauFinal;
	}

	public void setGrauFinal(double grauFinal) {
		this.grauFinal = grauFinal;
	}
	

}
