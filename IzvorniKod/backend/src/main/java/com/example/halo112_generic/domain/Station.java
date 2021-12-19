package com.example.halo112_generic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique = true)
    String name;

    @OneToOne
    @JoinColumn(name = "director_id")
    @NotNull
    private Responder director;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @NotNull
    private Location location;

    @NotNull
    private StationType type;

    public Station(String name, Responder director, Location location, StationType type) {
        this.name = name;
        this.director = director;
        this.location = location;
        this.type = type;
    }

    public Station() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Responder getDirector() {
        return director;
    }

    public void setDirector(Responder director) {
        this.director = director;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public StationType getType() {
        return type;
    }

    public void setType(StationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", director=" + director +
                ", location=" + location +
                ", type=" + type +
                '}';
    }
}