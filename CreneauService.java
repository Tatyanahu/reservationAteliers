package com.cegepgg.demoreservationAteliers.service;

import java.util.List;
import java.util.Optional;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.models.Creneau;

public interface CreneauService {
	
  Optional<Creneau> findById(Long id);
 
   Creneau getCreneauById(Long id);
   Creneau saveCreneau(Creneau creneau);
   List<Creneau> getAllCreneaux();
   void updateCreneauAvailability(Long id, boolean isAvailable);
      List<Creneau> getCreneauxByClient(Client client);
      List<Creneau> findAllById(Long id);
   
}
