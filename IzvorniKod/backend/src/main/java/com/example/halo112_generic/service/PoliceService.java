package com.example.halo112_generic.service;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.PoliceAbilities;

@Component
public interface PoliceService {

	boolean setAbility(PoliceAbilities ability, Long id);

}
