package com.cegepgg.demoreservationAteliers.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.models.Creneau;

public interface ClientService {

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

	Client findByEmailAndMotDePasse(String email, String motDePasse);

//	List<Client> getAllClients();

}
