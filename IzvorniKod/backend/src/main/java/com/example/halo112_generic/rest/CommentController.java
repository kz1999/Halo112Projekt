package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.CommentRepository;
import com.example.halo112_generic.dao.LocationRepository;
import com.example.halo112_generic.domain.*;
import com.example.halo112_generic.service.ActionService;
import com.example.halo112_generic.service.CommentService;
import com.example.halo112_generic.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/komentari")
public class CommentController {

    @Autowired
    CommentRepository commentRepo;

    @Autowired
    CommentService commentService;

    @GetMapping("")
    public List<Comment> listComments() throws Exception {
        return commentService.listAll();
    }

    @PostMapping("")
    public Comment createComment(@RequestBody Comment comment) throws Exception {
        return commentService.createComment(comment);
    }
}
