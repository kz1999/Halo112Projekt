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

    @NotNull
    private Long director_id;

    @NotNull
    private Long location_id;

    @NotNull
    private StationType type;

    public Station(String name, Long director_id, Long location_id, StationType type) {
        this.name = name;
        this.director_id = director_id;
        this.location_id = location_id;
        this.type = type;
    }

    public Station() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_id) {
        this.director_id = director_id;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
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
                ", name='" + name + '\'' +
                ", director_id=" + director_id +
                ", location_id=" + location_id +
                ", type=" + type +
                '}';
    }
}