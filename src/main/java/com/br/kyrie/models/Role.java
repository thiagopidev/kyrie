package com.br.kyrie.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Classe modelo de perfil
 * @author Thiago Pinheiro
**/
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
public class Role implements Serializable, GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter(value = AccessLevel.NONE)
	@Column(length = 20, nullable = false)
	private String authority;
	
	@ManyToMany(mappedBy = "authorities")
	private List<User> users;
	
	@Override
	public String getAuthority() {
		return authority;
	}
}