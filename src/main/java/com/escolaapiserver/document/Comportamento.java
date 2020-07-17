package com.escolaapiserver.document;

public class Comportamento {
	
	private Classificacao status;
	private double pontuacao;
	
	protected Comportamento() {}

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
