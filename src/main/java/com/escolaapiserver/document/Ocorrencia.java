package com.escolaapiserver.document;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Ocorrencia {
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
	@Field("fato_observado")
	private String fatoObservado;
	private TipoConduta conduta;
	private String medida;
	private double valor;
	
	protected Ocorrencia() {}

	public Ocorrencia(Date data, String fatoObservado, TipoConduta conduta, String medida, double valor) {
		this.data = data;
		this.fatoObservado = fatoObservado;
		this.conduta = conduta;
		this.medida = medida;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFatoObservado() {
		return fatoObservado;
	}

	public void setFatoObservado(String fatoObservado) {
		this.fatoObservado = fatoObservado;
	}

	public TipoConduta getConduta() {
		return conduta;
	}

	public void setConduta(TipoConduta conduta) {
		this.conduta = conduta;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conduta == null) ? 0 : conduta.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((fatoObservado == null) ? 0 : fatoObservado.hashCode());
		result = prime * result + ((medida == null) ? 0 : medida.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Ocorrencia other = (Ocorrencia) obj;
		if (conduta == null) {
			if (other.conduta != null)
				return false;
		} else if (!conduta.equals(other.conduta))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (fatoObservado == null) {
			if (other.fatoObservado != null)
				return false;
		} else if (!fatoObservado.equals(other.fatoObservado))
			return false;
		if (medida == null) {
			if (other.medida != null)
				return false;
		} else if (!medida.equals(other.medida))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	

}
