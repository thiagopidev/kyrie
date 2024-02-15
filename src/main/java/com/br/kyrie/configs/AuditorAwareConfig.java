package com.br.kyrie.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.br.kyrie.services.AuditingService;

/**
 * Classe de configuração e habilitação de auditoria
 * @author Thiago Pinheiro
**/
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditingService")
public class AuditorAwareConfig {
	@Bean
	AuditorAware<String> auditorProvider() {
		return new AuditingService();
	}
}