package com.cegepgg.demoreservationAteliers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegepgg.demoreservationAteliers.models.Atelier;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long>{

}
