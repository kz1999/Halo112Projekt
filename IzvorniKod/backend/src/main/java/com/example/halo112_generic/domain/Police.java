package com.example.halo112_generic.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "police")
public class Police extends Responder {
	private PoliceAbilities abilities;

	public PoliceAbilities getAbilities() {
		return abilities;
	}

	public void setAbilities(PoliceAbilities abilities) {
		this.abilities = abilities;
	}

}
