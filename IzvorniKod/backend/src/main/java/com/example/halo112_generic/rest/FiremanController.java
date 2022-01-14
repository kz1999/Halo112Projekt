package com.example.halo112_generic.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.Fireman;
import com.example.halo112_generic.domain.FiremanAbilities;
import com.example.halo112_generic.domain.Police;
import com.example.halo112_generic.service.FiremanService;

@RestController
@RequestMapping("/fireman")
public class FiremanController {
	@Autowired
	private FiremanService firemanService;
	
	@GetMapping("")
	public List<Fireman> listFiremen() throws Exception {
        return firemanService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Fireman> findById(@PathVariable Long id){
        return firemanService.findById(id);
    }
	
	@PostMapping("/ability/{id}")
    public boolean setAbility(@RequestBody FiremanAbilities ability, @PathVariable Long id) throws Exception {
        return firemanService.setAbility(ability, id);
    }

}
