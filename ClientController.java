package com.cegepgg.demoreservationAteliers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.models.Creneau;
import com.cegepgg.demoreservationAteliers.repositories.ClientRepository;
import com.cegepgg.demoreservationAteliers.service.ClientService;
import com.cegepgg.demoreservationAteliers.service.CreneauService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	@Autowired
    private ClientService clientService;
	
	@Autowired
    private CreneauService creneauService;
	

    @GetMapping("/login")
    public String showLoginForm() {
    	return "login";}
        
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String motDePasse, HttpSession session) {
        // Authenticate the client (implement clientService.findByEmailAndPassword)
        Client client = clientService.findByEmailAndMotDePasse(email, motDePasse);

        if (client != null) {
            // Store client information in the session
            session.setAttribute("client", client);
            return "redirect:/creneaux";
        } else {
            // Handle authentication failure
            return "login"; // Redirect to the login page with an error message
        }
    }
        
        @GetMapping("/logout")
        public String logout(HttpSession session) {
            // Invalidate the session to log out the client
            session.invalidate();
            return "redirect:/login";
        }

        @GetMapping("/dashboard")
        public String clientDashboard(Model model, HttpSession session) {
            // Retrieve client information from the session
            Client client = (Client) session.getAttribute("client");

            if (client != null) {
                // Retrieve client-specific data (adjust as needed)
                List<Creneau> clientCreneaux = creneauService.getCreneauxByClient(client);

                model.addAttribute("client", client);
                model.addAttribute("clientCreneaux", clientCreneaux);

                return "client_dashboard";
            } else {
                // Redirect to the login page if the client is not authenticated
                return "redirect:/login";
            }
    }
//        @GetMapping("/clients")
//	    public String listClients(Model model) {
//	        model.addAttribute("clients", clientService.getAllCLients());
//	        return "liste_clients";
//	    }
}
