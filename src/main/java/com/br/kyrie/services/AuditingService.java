package com.br.kyrie.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Classe de serviço de auditoria
 * @author Thiago Pinheiro do Nascimento
**/
@Service
public class AuditingService implements AuditorAware<String>{
	
	/**
	 * Método de carregamento de usuário logado para auditoria
	 * @author Thiago Pinheiro
	**/
	@Override
	public Optional<String> getCurrentAuditor() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return Optional.of(((UserDetails) principal).getUsername()); 
		return Optional.of(principal.toString());
	}
}