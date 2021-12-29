package com.example.halo112_generic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.FiremanRepository;
import com.example.halo112_generic.domain.Fireman;
import com.example.halo112_generic.domain.FiremanAbilities;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.FiremanService;

@Component
public class FiremanServiceJpa implements FiremanService{
	@Autowired
    private FiremanRepository firemanRepo;

	@Override
	public boolean setAbility(FiremanAbilities ability, Long id) {
		if (firemanRepo.existsById(id)) {
			Fireman fireman = firemanRepo.findById(id).get();
			fireman.setAbilities(ability);;
			firemanRepo.save(fireman);
			return true;
		}
		return false;
	}

}
