package com.cegepgg.demoreservationAteliers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegepgg.demoreservationAteliers.models.Artisan;
@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long>{

}
