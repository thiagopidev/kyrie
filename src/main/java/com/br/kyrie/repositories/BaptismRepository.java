package com.br.kyrie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.kyrie.models.Baptism;

/**
 * Interface de repositório de batismo
 * @author Thiago Pinheiro
**/
@Repository
public interface BaptismRepository extends JpaRepository<Baptism, Long>{

}