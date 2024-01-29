package com.br.kyrie.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Classe controller de redirecionamento para páginas de erro
 * @author Thiago Pinheiro
**/
@Controller
public class DeviationController implements ErrorController {

	@RequestMapping("/error")
	public String handlerError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.FORBIDDEN.value())
				return "errors/403";
			else if (statusCode == HttpStatus.NOT_FOUND.value())
				return "errors/404";
			else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
				return "errors/500";
		}
		return "errors/default";
	}
}