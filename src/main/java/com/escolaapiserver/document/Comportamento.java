package com.escolaapiserver.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comportamento {
	
	private Classificacao status;
	private double pontuacao;
	
	public Comportamento() {}

	public Classificacao getStatus() {
		return status;
	}

	public void setStatus(Classificacao status) {
		this.status = status;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
