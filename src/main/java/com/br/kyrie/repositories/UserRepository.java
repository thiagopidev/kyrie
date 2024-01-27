package com.br.kyrie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.kyrie.models.User;

/**
 * Interface de repositório de usuários
 * @author Thiago Pinheiro
**/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);
}