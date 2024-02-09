package com.br.kyrie.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe para redirecionamento de exceções
 * @author Thiago Pinheiro
**/
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(EntityNotPersistedException.class)
	public String handleEntityNotPersistedException(EntityNotPersistedException e) {
		return "errors/400";
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public String handleEntityNotFoundException(EntityNotFoundException e) {
		return "errors/404";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleIllegalArgumentException(IllegalArgumentException e) {
		return "errors/400";
	}
}