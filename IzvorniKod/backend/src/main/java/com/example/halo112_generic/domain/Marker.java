package com.example.halo112_generic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marker")
public class Marker {
	@Id
	@GeneratedValue
	private Long id;

	private String image;
	
	@OneToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Marker [id=" + id + ", image=" + image + ", location=" + location + "]";
	}

}
