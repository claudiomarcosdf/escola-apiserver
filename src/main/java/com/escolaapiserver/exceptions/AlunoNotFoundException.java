package com.escolaapiserver.exceptions;

public class AlunoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoNotFoundException(String mensagem) {
		super(mensagem);
	}

}
