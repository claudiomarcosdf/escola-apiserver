package com.escolaapiserver.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="tabela-medida")
public class TabelaMedida {
	
	@Id
	private String Id;
	private String descricao;
	@Field("tipo_conduta")
	private TipoConduta tipoConduta;
	private double valor;
	
	public TabelaMedida(String descricao, TipoConduta tipoConduta, double valor) {
		this.descricao = descricao;
		this.tipoConduta = tipoConduta;
		this.valor = valor;
	}

	public String getId() {
		return Id;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoConduta getTipo() {
		return tipoConduta;
	}

	public void setTipo(TipoConduta tipoConduta) {
		this.tipoConduta = tipoConduta;
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
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		TabelaMedida other = (TabelaMedida) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
