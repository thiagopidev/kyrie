package com.br.kyrie.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.br.kyrie.services.AppUserDetailsService;

/**
 * Classe de configurações de autenticação e autorização
 * @author Thiago Pinheiro
**/
@Configuration
public class WebSecurityConfig {

	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
		requestCache.setMatchingRequestParameterName(null);
		http.requestCache(
				cache -> {
					cache.requestCache(requestCache);
				}
		)
		.authorizeHttpRequests(
				authorizeConfig -> {
					authorizeConfig.requestMatchers("/login").permitAll();
					authorizeConfig.anyRequest().authenticated();
				}
		)
		.formLogin(
				form -> {
					form.loginPage("/login");
					form.defaultSuccessUrl("/", true);
					form.usernameParameter("username");
					form.passwordParameter("password");
					form.failureUrl("/login?error=true");
				}
		)
		.logout(
				logout -> {
					logout.logoutSuccessUrl("/login");
					logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
				}
		)
		.sessionManagement(
				session -> {
					session.maximumSessions(1);
					session.invalidSessionUrl("/login");
				}
		);
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.debug(false).ignoring().requestMatchers("/css/**", "/images/**", "/js/**", "/vendors/**");
	}
	
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(appUserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
}