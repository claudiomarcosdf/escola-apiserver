package com.escolaapiserver.document;

import java.text.NumberFormat;
import java.util.Locale;

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
		Locale locale = Locale.ENGLISH;
		NumberFormat nf = NumberFormat.getNumberInstance(locale);
		nf.setMaximumFractionDigits(2);
		
		return Double.valueOf(nf.format(pontuacao));
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
