package com.example.halo112_generic.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dispatcher")
public class Dispatcher{
	@Id
    @GeneratedValue
    private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
    
    @OneToOne
    @JoinColumn(name = "map_id")
    private Map map;

	@OneToMany(targetEntity = Action.class)
	private List<Action> actions;

	public Dispatcher(User user, Map map, List<Action> actions) {
		this.user = user;
		this.map = map;
		this.actions = actions;
	}

	public Dispatcher() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Dispatcher{" +
				"id=" + id +
				", user=" + user +
				", map=" + map +
				", actions=" + actions +
				'}';
	}
	//	@Override
//	public String toString() {
//		return "Dispatcher [id=" + id + ", user=" + user + ", actions=" + actions + "]";
//	}

}
