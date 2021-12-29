package com.example.halo112_generic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.FiremanAbilities;
import com.example.halo112_generic.service.FiremanService;

@RestController
@RequestMapping("/fireman")
public class FiremanController {
	@Autowired
	private FiremanService firemanService;
	
	@PostMapping("/ability/{id}")
    public boolean setAbility(@RequestBody FiremanAbilities ability, @PathVariable Long id) throws Exception {
        return firemanService.setAbility(ability, id);
    }

}
