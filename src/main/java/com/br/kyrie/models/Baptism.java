package com.br.kyrie.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe modelo de definição de batismo
 * @author Thiago Pinheiro
**/
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "baptisms")
public class Baptism implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Descrição é obrigatória")
	@Column(length = 50, nullable = false)
	private String description;
	
	@NotNull(message = "Data é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(columnDefinition = "date", nullable = false)
	private Date date;
	
	@Column(name = "opened_registration", columnDefinition = "tinyint(1) default 0")
	private Boolean openedForRegistration;
	
	@CreationTimestamp
	@Column(columnDefinition = "datetime", nullable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(columnDefinition = "datetime", nullable = false)
	private LocalDateTime updatedAt;
}