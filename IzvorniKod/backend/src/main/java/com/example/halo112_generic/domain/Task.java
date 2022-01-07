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

    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comments;

    public Task(Long id, String text, Long responder_id, List<Comment> comments) {
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
                ", responder_id=" + responder_id +
                ", comments=" + comments +
                '}';
    }
}
