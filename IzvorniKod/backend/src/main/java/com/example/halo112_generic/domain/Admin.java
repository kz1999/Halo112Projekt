package com.example.halo112_generic.domain;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin{
	
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @MapsId
    private User user;

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

}
