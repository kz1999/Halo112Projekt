package com.example.halo112_generic.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dispatcher")
public class Dispatcher{
	@Id
    @GeneratedValue
    private Long id;

    private Long user_id;

    private Long map_id;

	@ElementCollection
	private List<Long> actions;

	public Dispatcher(Long user_id, Long map_id, List<Long> actions) {
		this.user_id = user_id;
		this.map_id = map_id;
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

	public Long getUser() {
		return user_id;
	}

	public void setUser(Long user_id) {
		this.user_id = user_id;
	}

	public Long getMap() {
		return map_id;
	}

	public void setMap(Long map_id) {
		this.map_id = map_id;
	}

	public List<Long> getActions() {
		return actions;
	}

	public void setActions(List<Long> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Dispatcher{" +
				"id=" + id +
				", user_id=" + user_id +
				", map_id=" + map_id +
				", actions=" + actions +
				'}';
	}
	//	@Override
//	public String toString() {
//		return "Dispatcher [id=" + id + ", user_id=" + user_id + ", actions=" + actions + "]";
//	}

}
