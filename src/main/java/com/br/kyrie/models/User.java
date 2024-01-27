package com.br.kyrie.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Classe modelo de usuários
 * @author Thiago Pinheiro
**/
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter(value = AccessLevel.NONE)
	@Column(length = 60, nullable = false)
	private String password;
	
	@Getter(value = AccessLevel.NONE)
	@Column(length = 50, nullable = false)
	private String username;
	
	@Getter(value = AccessLevel.NONE)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(
			name = "users_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
			name = "roles_id", referencedColumnName = "id"))
	private List<Role> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}