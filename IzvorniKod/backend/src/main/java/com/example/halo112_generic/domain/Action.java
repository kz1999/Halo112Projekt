package com.example.halo112_generic.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private List<Responder> team;

    private int urgency;

    private List<Task> tasks;

    private List<Comment> comments;

    private String description;

    private List<String> gallery;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public Location getLocation() {
        return location;
    }

    public Action(Long id, Location location, List<Responder> team, int urgency, List<Task> tasks) {
        this.id = id;
        this.location = location;
        this.team = team;
        this.urgency = urgency;
        this.tasks = tasks;
    }

    public Action() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Responder> getTeam() {
        return team;
    }

    public void setTeam(List<Responder> team) {
        this.team = team;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", location=" + location +
                ", team=" + team +
                ", urgency=" + urgency +
                ", tasks=" + tasks +
                '}';
    }
}
