package com.cegepgg.demoreservationAteliers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cegepgg.demoreservationAteliers.service.AtelierService;
@Controller
public class AtelierComtroller {
	
	private final AtelierService atelierService;

	@Autowired
	public AtelierComtroller(AtelierService atelierService) {
		this.atelierService = atelierService;
	}
	
	@GetMapping("/ateliers")
	public String listAtelier(Model model) {
		model.addAttribute("ateliers", atelierService.getAllAteliers());
		return "liste_ateliers";
	}
	

}
