package com.br.kyrie.exceptions;

/**
 * Classe de exceção de entidade não encontrada
 * @author Thiago Pinheiro
**/
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String message) {
		super(message);
	}
}