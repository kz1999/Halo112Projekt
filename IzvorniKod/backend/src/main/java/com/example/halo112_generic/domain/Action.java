package com.example.halo112_generic.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    /*
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
     */

    @OneToMany(targetEntity = Responder.class)
    private List<Responder> team;

    private int urgency;

    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(targetEntity=Comment.class, cascade = CascadeType.ALL)
    private List<Comment> comments;

    private String description;

    @ElementCollection
    private List<String> gallery;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /*
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
     */

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
}
