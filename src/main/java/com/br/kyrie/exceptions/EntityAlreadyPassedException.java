package com.br.kyrie.exceptions;

/**
 * Classe de exceção de entidade ultrapassada
 * @author Thiago Pinheiro 
**/
public class EntityAlreadyPassedException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyPassedException(String message) {
		super(message);
	}
}