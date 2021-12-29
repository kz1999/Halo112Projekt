package com.example.halo112_generic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "police")
public class Police{
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn(name = "responder_id")
	private Responder responder;
	
	private PoliceAbilities abilities;

	public PoliceAbilities getAbilities() {
		return abilities;
	}

	public void setAbilities(PoliceAbilities abilities) {
		this.abilities = abilities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Responder getResponder() {
		return responder;
	}

	public void setResponder(Responder responder) {
		this.responder = responder;
	}

}
