package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/akcije")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<Action> listActions() throws Exception {
        return actionService.listAll();
    }

    @PostMapping("")
    public Action createAction(@RequestBody Action action) throws Exception {
        return actionService.createAction(action);
    }

    @GetMapping("/{id}")
    //@Secured("ROLE_ADMIN")
    public Optional<Action> findById(@PathVariable Long id) throws Exception {
        return actionService.findById(id);
    }

    @PostMapping("/{id}")
    //@Secured("ROLE_ADMIN")
    public Optional<Action> editAction(@PathVariable Long id, @RequestBody Action action) throws Exception {
        return actionService.editAction(id, action);
    }
}
