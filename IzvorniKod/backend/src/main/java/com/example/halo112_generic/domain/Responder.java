package com.example.halo112_generic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "responder")
public class Responder {
    @Id
    @GeneratedValue
    private Long id;

    private Long user_id;

    private String userName;

    private String role;

    private Long station_id;

    private boolean status;

    private Long currentAction_id;

    private Long location_id;

    private boolean isDirector;

    @ElementCollection
    private List<Long> requestsList;

    ResponderAbility responderAbility;

    public ResponderAbility getResponderAbility() {
        return responderAbility;
    }

    public void setResponderAbility(ResponderAbility responderAbility) {
        this.responderAbility = responderAbility;
    }

    public Responder(Long id, Long user_id, String userName, String role, Long station_id, boolean status, Long currentAction_id, Long location_id, boolean isDirector, List<Long> requestsList, ResponderAbility responderAbility) {
        this.id = id;
        this.user_id = user_id;
        this.userName = userName;
        this.role = role;
        this.station_id = station_id;
        this.status = status;
        this.currentAction_id = currentAction_id;
        this.location_id = location_id;
        this.isDirector = isDirector;
        this.requestsList = requestsList;
        this.responderAbility = responderAbility;
    }

    public Responder() {
    }

    public List<Long> getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(List<Long> requestsList) {
        this.requestsList = requestsList;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getStation_id() {
        return station_id;
    }

    public void setStation_id(Long station_id) {
        this.station_id = station_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getCurrentAction_id() {
        return currentAction_id;
    }

    public void setCurrentAction_id(Long currentAction_id) {
        this.currentAction_id = currentAction_id;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
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
                ", user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", station_id=" + station_id +
                ", status=" + status +
                ", currentAction_id=" + currentAction_id +
                ", location_id=" + location_id +
                ", isDirector=" + isDirector +
                ", requestsList=" + requestsList +
                '}';
    }
}
