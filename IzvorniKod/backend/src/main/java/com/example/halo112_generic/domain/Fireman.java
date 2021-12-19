package com.example.halo112_generic.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fireman")
public class Fireman extends Responder {
	
	private FiremanAbilities abilities;

	public FiremanAbilities getAbilities() {
		return abilities;
	}

	public void setAbilities(FiremanAbilities abilities) {
		this.abilities = abilities;
	}

}
