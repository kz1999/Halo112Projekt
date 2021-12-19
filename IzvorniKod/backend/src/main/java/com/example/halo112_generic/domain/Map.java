package com.example.halo112_generic.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "map")
public class Map {
	@Id
    @GeneratedValue
    private Long id;
	
	@OneToMany(targetEntity = Marker.class)
	private List<Marker> markers;
	
	@OneToMany(targetEntity = Route.class)
	private List<Route> routes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Marker> getMarkers() {
		return markers;
	}

	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

}
