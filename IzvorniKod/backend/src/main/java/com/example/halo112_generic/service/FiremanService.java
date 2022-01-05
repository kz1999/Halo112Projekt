package com.example.halo112_generic.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.Fireman;
import com.example.halo112_generic.domain.FiremanAbilities;

@Component
public interface FiremanService {

	Fireman createFireman(Fireman fireman);
	
	boolean setAbility(FiremanAbilities ability, Long id);

	List<Fireman> listAll();

}
