package com.cegepgg.demoreservationAteliers.service;

import java.util.List;
import java.util.Optional;

import com.cegepgg.demoreservationAteliers.models.Atelier;

public interface AtelierService {
	Atelier saveAtelier(Atelier atelier);
	Optional<Atelier> getAtelierById(Long id);
	List<Atelier> getAllAteliers();
	Atelier updateAtelier(Atelier atelier);
	void deleteAtelier(Long id);

}
