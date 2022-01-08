package com.example.halo112_generic.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private Long responder_id;
    
    @ElementCollection
    private List<Long> location_id;

    @ElementCollection
    private List<Long> comments;

    public Task(Long id, String text, Long responder_id, List<Long> comments) {
        this.id = id;
        this.text = text;
        this.responder_id = responder_id;
        this.comments = comments;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getResponder_id() {
        return responder_id;
    }

    public void setResponder_id(Long responder_id) {
        this.responder_id = responder_id;
    }

    public List<Long> getComments() {
        return comments;
    }

	public List<Long> getLocation_id() {
		return location_id;
	}

	public void setLocation_id(List<Long> location_id) {
		this.location_id = location_id;
	}

	public void setComments(List<Long> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", responder_id=" + responder_id +
                ", comments=" + comments +
                '}';
    }
}
