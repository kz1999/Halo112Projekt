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

    @ManyToOne
    @JoinColumn(name = "responder_id")
    private Responder responder;

    private List<Comment> comments;

    public Responder getResponder() {
        return responder;
    }

    public Task(Long id, String text, Responder responder, List<Comment> comments) {
        this.id = id;
        this.text = text;
        this.responder = responder;
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

    public void setResponder(Responder responder) {
        this.responder = responder;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", responder=" + responder +
                ", comments=" + comments +
                '}';
    }
}
