package com.example.halo112_generic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue
    private Long id;

    private Long action_id;

    private int emergencyLevel;

    private String responderAbility;

    public Request(Long id, Long action_id, int emergencyLevel, String responderAbility) {
        this.id = id;
        this.action_id = action_id;
        this.emergencyLevel = emergencyLevel;
        this.responderAbility = responderAbility;
    }

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAction_id() {
        return action_id;
    }

    public void setAction_id(Long action_id) {
        this.action_id = action_id;
    }

    public int getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(int emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public String getResponderAbility() {
        return responderAbility;
    }

    public void setResponderAbility(String responderAbility) {
        this.responderAbility = responderAbility;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", action_id=" + action_id +
                ", emergencyLevel=" + emergencyLevel +
                ", responderAbility=" + responderAbility +
                '}';
    }
}
