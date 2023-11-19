package com.cegepgg.demoreservationAteliers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cegepgg.demoreservationAteliers.models.Atelier;
import com.cegepgg.demoreservationAteliers.repositories.AtelierRepository;

@Service
@Transactional
public class AtelierServiceImpl implements AtelierService{
	
	private final AtelierRepository atelierRepository;
	
	@Autowired
	public AtelierServiceImpl(AtelierRepository atelierRepository) {
		this.atelierRepository=atelierRepository;
	}

	@Override
	public Atelier saveAtelier(Atelier atelier) {

		return atelierRepository.save(atelier);
	}

	@Override
	public Optional<Atelier> getAtelierById(Long id) {
		return atelierRepository.findById(id);
	}

	@Override
	public List<Atelier> getAllAteliers() {
		return atelierRepository.findAll();
	}

	@Override
	public Atelier updateAtelier(Atelier atelier) {
		return atelierRepository.save(atelier);
	}

	@Override
	public void deleteAtelier(Long id) {
		atelierRepository.deleteById(id);
		
	}

}
