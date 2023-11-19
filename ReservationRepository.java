package com.cegepgg.demoreservationAteliers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegepgg.demoreservationAteliers.models.Client;

@Repository
public interface ReservationRepository extends JpaRepository<Client, Long>{

	Client findByEmail(String email);

}
