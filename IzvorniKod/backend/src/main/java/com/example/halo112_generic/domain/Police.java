package com.example.halo112_generic.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "police")
public class Police{
	@Id
	@GeneratedValue
	private Long id;

	private Long responder_id;
	
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

	public Long getResponder() {
		return responder_id;
	}

	public void setResponder(Long responder_id) {
		this.responder_id = responder_id;
	}

}
