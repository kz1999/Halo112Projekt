package com.example.halo112_generic.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.Paramedic;
import com.example.halo112_generic.domain.ParamedicAbilities;

@Component
public interface ParamedicService {

	Paramedic createParamed(Paramedic paramed);
	
	boolean setAbility(ParamedicAbilities ability, Long id);

	List<Paramedic> listAll();

}
