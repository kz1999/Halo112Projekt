package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.CommentRepository;
import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.Comment;
import com.example.halo112_generic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommentServiceJpa implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Comment> listAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment createComment(Comment comment) {
        if(comment.getUserName()==null && comment.getOwner()!=null){
            comment.setUserName(userRepo.getById(comment.getOwner()).getUserName());
        }
        return commentRepo.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepo.findCommentById(id);
    }

    @Override
    public Comment editComment(Long id, Comment comment) {
        /*
        if(comment.getOwner()!=null) commentRepo.editCommentOwner(comment.getOwner(), id);
        if(comment.getText()!=null) commentRepo.editCommentText(comment.getText(), id);

         */
        return commentRepo.save(comment);
    }
}
