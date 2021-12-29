package com.example.halo112_generic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.ParamedicRepository;
import com.example.halo112_generic.domain.Paramedic;
import com.example.halo112_generic.domain.ParamedicAbilities;
import com.example.halo112_generic.service.ParamedicService;

@Component
public class ParamedicServiceJpa implements ParamedicService{
	@Autowired
    private ParamedicRepository paramedicRepo;

	@Override
	public boolean setAbility(ParamedicAbilities ability, Long id) {
		if (paramedicRepo.existsById(id)) {
			Paramedic paramedic = paramedicRepo.findById(id).get();
			paramedic.setAbilities(ability);;
			paramedicRepo.save(paramedic);
			return true;
		}
		return false;
	}

}
