package com.cegepgg.demoreservationAteliers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.models.Creneau;

@Repository
public interface CreneauRepository extends JpaRepository<Creneau, Long>{

	List<Creneau> findByClient(Client client);
	List<Creneau> findByClientId(Long clientId);
	List<Creneau> getCreneauxByClient(Client client);
	List<Creneau> findAllById(Long id);

}
