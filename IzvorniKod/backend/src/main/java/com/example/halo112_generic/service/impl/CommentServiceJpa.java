package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.CommentRepository;
import com.example.halo112_generic.domain.Comment;
import com.example.halo112_generic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommentServiceJpa implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public List<Comment> listAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepo.findCommentById(id);
    }

    @Override
    public Optional<Comment> editComment(Long id, Comment comment) {
        if(comment.getOwner()!=null) commentRepo.editCommentOwner(comment.getOwner(), id);
        if(comment.getText()!=null) commentRepo.editCommentText(comment.getText(), id);
        return commentRepo.findCommentById(id);
    }
}
