package com.example.halo112_generic.service;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.FiremanAbilities;

@Component
public interface FiremanService {

	boolean setAbility(FiremanAbilities ability, Long id);

}
