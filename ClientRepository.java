package com.cegepgg.demoreservationAteliers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cegepgg.demoreservationAteliers.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	List<Client> getAllClients = null;

	Client findByEmail(String email);

	Client findByEmailAndMotDePasse(String email, String motDePasse);

}
