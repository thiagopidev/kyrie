package com.br.kyrie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.kyrie.exceptions.EntityNotFoundException;
import com.br.kyrie.exceptions.EntityNotPersistedException;
import com.br.kyrie.models.Baptism;
import com.br.kyrie.repositories.BaptismRepository;

/**
 * Classe de serviço de batismo
 * @author Thiago Pinheiro
**/
@Service
public class BaptismService {
	
	@Autowired
	private BaptismRepository baptismRepository;
	
	@Transactional
	public void persist(Baptism baptism) {
		if(baptismRepository.save(baptism) == null)
			throw new EntityNotPersistedException("Erro ao salvar batismo");
	}
	
	public Baptism getById(Long id) {
		Optional<Baptism> baptism = baptismRepository.findById(id);
		if(baptism.isEmpty())
			throw new EntityNotFoundException("Batismo não encontrado");
		return baptism.get();
	}
	
	@Transactional
	public void remove (Baptism baptism) {
		baptismRepository.deleteById(baptism.getId());
	}
}