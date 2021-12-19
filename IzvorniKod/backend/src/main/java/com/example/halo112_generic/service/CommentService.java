package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> listAll();

    Comment createComment(Comment action);

    Optional<Comment> findById(Long id);

    Optional<Comment> editComment(Long id, Comment action);
}
