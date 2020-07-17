package com.escolaapiserver.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tabela-transgressao")
public class TabelaTransgressao {
	
	@Id
	private String Id;
	private String codigo;
	private String transgressao;
	
	public TabelaTransgressao(String codigo, String transgressao) {
		this.codigo = codigo;
		this.transgressao = transgressao;
	}

	public String getId() {
		return Id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTransgressao() {
		return transgressao;
	}

	public void setTransgressao(String transgressao) {
		this.transgressao = transgressao;
	}
	
}
