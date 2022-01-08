package com.example.halo112_generic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.Police;
import com.example.halo112_generic.domain.PoliceAbilities;

@Component
public interface PoliceService {

	Police createPolice(Police police);
	
	boolean setAbility(PoliceAbilities ability, Long id);

	Optional<Police> findById(Long id);

	List<Police> listAll();

}
