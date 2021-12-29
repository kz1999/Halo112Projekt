package com.example.halo112_generic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.PoliceAbilities;
import com.example.halo112_generic.service.PoliceService;

@RestController
@RequestMapping("/police")
public class PoliceController {
	@Autowired
	private PoliceService policeService;
	
	@PostMapping("/ability/{id}")
    public boolean setAbility(@RequestBody PoliceAbilities ability, @PathVariable Long id) throws Exception {
        return policeService.setAbility(ability, id);
    }

}
