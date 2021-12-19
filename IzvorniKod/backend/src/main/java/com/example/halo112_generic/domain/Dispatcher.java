package com.example.halo112_generic.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dispatcher")
public class Dispatcher {
	@Id
    @GeneratedValue
    private Long id;
	
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToOne
    @JoinColumn(name = "map_id")
    private Map map;

	@OneToMany(targetEntity = Action.class)
	private List<Action> actions;
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
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

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Dispatcher [id=" + id + ", user=" + user + ", actions=" + actions + "]";
	}

}
