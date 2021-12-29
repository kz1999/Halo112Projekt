package com.example.halo112_generic.service;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.ParamedicAbilities;

@Component
public interface ParamedicService {

	boolean setAbility(ParamedicAbilities ability, Long id);

}
