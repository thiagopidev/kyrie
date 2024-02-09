package com.br.kyrie.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.kyrie.models.Baptism;
import com.br.kyrie.repositories.BaptismRepository;
import com.br.kyrie.services.BaptismService;

import jakarta.validation.Valid;

/**
 * Classe controller de definição de batismo
 * @author Thiago Pinheiro
**/
@Controller
@RequestMapping("/batismo")
public class BaptismController {
	
	@Autowired
	private BaptismRepository baptismRepository;
	
	@Autowired
	private BaptismService baptismService;
	
	@GetMapping
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView("baptisms/search");
		mv.addObject("baptisms", baptismRepository.findAll());
		mv.addObject("menu", "baptism");
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView create(Baptism baptism) {
		ModelAndView mv = new ModelAndView("baptisms/create");
		mv.addObject("menu", "baptism");
		return mv;
	}
	
	@PostMapping
	public ModelAndView create(@Valid Baptism baptism, BindingResult result) {
		if(result.hasErrors())
			return this.create(baptism);
		baptismService.persist(baptism);
		return new ModelAndView("redirect:/batismo");
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView update(@PathVariable("id") Long id, Baptism baptism, boolean invalid) {
		ModelAndView mv = new ModelAndView("baptisms/update");
		if(!invalid)
			baptism = baptismService.getById(id);
		mv.addObject("baptism", baptism);
		mv.addObject("menu", "baptism");
		return mv;
	}
	
	@PostMapping("/editar")
	public ModelAndView update(@Valid Baptism baptism, BindingResult result) {
		if(result.hasErrors())
			return update(baptism.getId(), baptism, true);
		Baptism persistedBaptism = baptismService.getById(baptism.getId());
		BeanUtils.copyProperties(baptism, persistedBaptism, "id", "createdAt");
		baptismService.persist(persistedBaptism);
		return new ModelAndView("redirect:/batismo");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Baptism baptism = baptismService.getById(id);
		baptismService.remove(baptism);
		return new ModelAndView("redirect:/batismo");
	}
}