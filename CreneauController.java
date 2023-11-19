package com.cegepgg.demoreservationAteliers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cegepgg.demoreservationAteliers.service.CreneauService;

public class CreneauController {

	   private final CreneauService creneauService;

	    @Autowired
	    public CreneauController(CreneauService creneauService) {
	        this.creneauService = creneauService;
	    }

	    @GetMapping("/creneaux")
	    public String listCreneaux(Model model) {
	        model.addAttribute("creneaux", creneauService.getAllCreneaux());
	        return "liste_creneaux";
	    }
}
