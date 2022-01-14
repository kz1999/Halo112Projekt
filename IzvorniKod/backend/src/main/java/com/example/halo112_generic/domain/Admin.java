package com.example.halo112_generic.domain;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin{
	
    @Id
    @GeneratedValue
    private Long id;

    private Long user_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
