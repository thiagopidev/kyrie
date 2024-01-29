package com.br.kyrie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	
	@RequestMapping("/login")
	public String formLogin () {
		return "login";
	}
}