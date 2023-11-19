package com.cegepgg.demoreservationAteliers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.models.Commande;
import com.cegepgg.demoreservationAteliers.models.Creneau;
import com.cegepgg.demoreservationAteliers.repositories.CreneauRepository;
import com.cegepgg.demoreservationAteliers.service.CreneauService;
import com.cegepgg.demoreservationAteliers.service.ReservationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {

	private final CreneauService creneauService;
	private final ReservationService reservationService;

    @Autowired
    private CreneauRepository creneauRepository;
	

	  @Autowired
	    public ReservationController(CreneauService creneauService, ReservationService reservationService) {
	        this.creneauService = creneauService;
	        this.reservationService = reservationService;
	    }

    @GetMapping("/creneaux")
    public String listCreneaux(Model model) {
        model.addAttribute("creneaux", creneauService.getAllCreneaux());
        return "liste_creneaux";
    }

    @PostMapping("/makeReservation")
    public String makeReservation(@RequestParam("selectedCreneaux") List<Long> selectedCreneaux,HttpSession session) {
    	

    	// Retrieve client information from the session
        Client currentUser = (Client) session.getAttribute("client");
        
        if (currentUser != null && selectedCreneaux != null && !selectedCreneaux.isEmpty()) {
        	
        	Commande commande = new Commande();
        	commande.setClient(currentUser);
       	List<Creneau> creneaux = creneauRepository.findAllById(selectedCreneaux);
       	 commande.setCreneaux(creneaux);
            for (Long creneauId : selectedCreneaux) {
                Creneau creneau = creneauService.getCreneauById(creneauId);
                if (creneau != null && creneau.isAvailable()) {
                	
                   
                    creneau.setAvailable(false);
                    creneau.setClient(currentUser);
                    creneauService.updateCreneauAvailability(creneauId, false);
                }
            }
            return "reservation_confirmation"; // Redirect to a confirmation page
        } else {
            // Redirect to the login page if the client is not authenticated
            return "redirect:/login";
        }
    }

    
}
