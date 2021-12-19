package com.example.halo112_generic.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paramedic")
public class Paramedic extends Responder {
	private ParamedicAbilities abilities;

	public ParamedicAbilities getAbilities() {
		return abilities;
	}

	public void setAbilities(ParamedicAbilities abilities) {
		this.abilities = abilities;
	}
}
