package com.example.halo112_generic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "responder")
public class Responder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "current_action_id")
    private Action currentAction;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private boolean isDirector;

    public Responder(Long id, Station station, boolean status, Action currentAction, Location location, boolean isDirector) {
        this.id = id;
        this.station = station;
        this.status = status;
        this.currentAction = currentAction;
        this.location = location;
        this.isDirector = isDirector;
    }

    public Responder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isDirector() {
        return isDirector;
    }

    public void setDirector(boolean director) {
        isDirector = director;
    }

    @Override
    public String toString() {
        return "Responder{" +
                "id=" + id +
                ", station=" + station +
                ", status=" + status +
                ", currentAction=" + currentAction +
                ", location=" + location +
                ", isDirector=" + isDirector +
                '}';
    }
}
