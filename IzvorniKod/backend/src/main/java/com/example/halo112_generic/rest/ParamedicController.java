package com.example.halo112_generic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.ParamedicAbilities;
import com.example.halo112_generic.service.ParamedicService;

@RestController
@RequestMapping("/paramedic")
public class ParamedicController {
	@Autowired
	private ParamedicService paramedicService;

	@PostMapping("/ability/{id}")
	public boolean setAbility(@RequestBody ParamedicAbilities ability, @PathVariable Long id) throws Exception {
		return paramedicService.setAbility(ability, id);
	}

}
