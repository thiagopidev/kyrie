package com.br.kyrie.exceptions;

/**
 * Classe de exceção de entidade não persistida
 * @author Thiago Pinheiro
**/
public class EntityNotPersistedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityNotPersistedException(String message) {
		super(message);
	}
}