package com.example.halo112_generic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.PoliceRepository;
import com.example.halo112_generic.domain.Police;
import com.example.halo112_generic.domain.PoliceAbilities;
import com.example.halo112_generic.service.PoliceService;

@Component
public class PoliceServiceJpa implements PoliceService{
	@Autowired
    private PoliceRepository policeRepo;

	@Override
	public boolean setAbility(PoliceAbilities ability, Long id) {
		if (policeRepo.existsById(id)) {
			Police police = policeRepo.findById(id).get();
			police.setAbilities(ability);;
			policeRepo.save(police);
			return true;
		}
		return false;
	}

}
