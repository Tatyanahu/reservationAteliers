package com.cegepgg.demoreservationAteliers.service;

import com.cegepgg.demoreservationAteliers.models.Client;

public interface ReservationService {
	
	Client getCurrentUser();
    Client findByEmail(String email);

}
