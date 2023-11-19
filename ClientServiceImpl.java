package com.cegepgg.demoreservationAteliers.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.cegepgg.demoreservationAteliers.models.Client;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cegepgg.demoreservationAteliers.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	 @Autowired
	    private ClientRepository clientRepository;
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Client client = clientRepository.findByEmail(email);
	        if (client == null) {
	            throw new UsernameNotFoundException("User not found with email: " + email);
	        }
	        return new User(client.getEmail(), client.getMotDePasse(), Collections.emptyList());
	    }
	@Override
	public Client findByEmailAndMotDePasse(String email, String motDePasse) {
		
		return clientRepository.findByEmailAndMotDePasse(email, motDePasse);
	}
//	@Override
//	public List<Client> getAllClients() {
//		return ClientRepository.getAllClients;
//	}

}
