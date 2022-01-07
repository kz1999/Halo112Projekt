package com.example.halo112_generic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "responder")
public class Responder extends User{

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

    public Responder(Long id, String userName, String photo, String passwordHash, String name, String surname, String phoneNumber, String email, String role, boolean confirmed) {
        super(id, userName, photo, passwordHash, name, surname, phoneNumber, email, role, confirmed);
    }

    public Responder(User user) {
        super(user.getId(), user.getUserName(), user.getPhoto(), user.getPasswordHash(), user.getName(), user.getSurname(), user.getPhoneNumber(), user.getEmail(), user.getRole(), user.isConfirmed());
    }

    public Responder(){

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
}
