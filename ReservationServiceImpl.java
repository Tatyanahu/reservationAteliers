package com.cegepgg.demoreservationAteliers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.repositories.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	
	private final ReservationRepository reservationRepository;
	
	   @Autowired
	    public ReservationServiceImpl(ReservationRepository reservationRepository) {
	        this.reservationRepository = reservationRepository;
	    }

	@Override
	public Client getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            Client userDetails = (Client) authentication.getPrincipal();
            
            // Assuming your UserDetails implementation has a method to retrieve the email or username
            String userEmail = userDetails.getEmail();

            // Now, you need to fetch the Client from the database based on the email
            // This might involve using a service or repository method to find the client by email
             Client client = reservationRepository.findByEmail(userEmail);
            
            // Return the found Client
            return client;
        }

        // Return null or handle the case where the user is not authenticated
        return null;
	}

	@Override
	public Client findByEmail(String email) {
		
		return reservationRepository.findByEmail(email);
	}

}
