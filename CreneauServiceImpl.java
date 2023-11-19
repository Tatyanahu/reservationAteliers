package com.cegepgg.demoreservationAteliers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cegepgg.demoreservationAteliers.models.Client;
import com.cegepgg.demoreservationAteliers.models.Creneau;
import com.cegepgg.demoreservationAteliers.repositories.CreneauRepository;

@Service
@Transactional
public class CreneauServiceImpl implements CreneauService{
	
	private final CreneauRepository creneauRepository;

    @Autowired
    public CreneauServiceImpl(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }

    @Override
    public List<Creneau> getAllCreneaux() {
        return creneauRepository.findAll();
    }

	@Override
	public Optional<Creneau> findById(Long id) {
		return creneauRepository.findById(id);
	}

	@Override
	public Creneau saveCreneau(Creneau creneau) {

		return creneauRepository.save(creneau);
	}

	@Override
	public Creneau getCreneauById(Long id) {
		return creneauRepository.findById(id).orElse(null);
	}

	@Override
	public void updateCreneauAvailability(Long id, boolean isAvailable) {
	    Creneau creneau = getCreneauById(id);
        if (creneau != null) {
            creneau.setAvailable(isAvailable);
            creneauRepository.save(creneau);
        }
		
	}

	@Override
	public List<Creneau> getCreneauxByClient(Client client) {
		// TODO Auto-generated method stub
		return creneauRepository.findByClient(client);
	}

	@Override
	public List<Creneau> findAllById(Long id) {
		
		return creneauRepository.findByClientId(id);
	}




}
