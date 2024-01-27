package com.br.kyrie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.kyrie.models.User;
import com.br.kyrie.repositories.UserRepository;

/**
 * Classe de verificação e carregamento de usuário
 * @author Thiago Pinheiro
**/
@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isEmpty())
			throw new UsernameNotFoundException("Usuário e/ou senha não inválido(s)");
		return user.get();
	}
}