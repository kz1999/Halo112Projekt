package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ActionRepository;
import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActionServiceJpa implements ActionService {
    @Autowired
    private ActionRepository actionRepo;

    @Override
    public List<Action> listAll() {
        return actionRepo.findAll();
    }

    @Override
    public Action createAction(Action action) {
        return actionRepo.save(action);
    }

    @Override
    public Optional<Action> findById(Long id) {
        return actionRepo.findActionById(id);
    }

    @Override
    public Optional<Action> editAction(Long id, Action action) {
        if(action.getLocation().getId()!=null) actionRepo.editActionLocation(action.getLocation().getId(),id);
        //if(!action.getTasks().isEmpty()) actionRepo.editActionTasks(action.getTasks(),id);
        //if(action.getTeam().isEmpty()) actionRepo.editActionTeam(action.getTeam(),id);
        actionRepo.editActionUrgency(action.getUrgency(),id);
        if(action.getDescription()!=null) actionRepo.editActionDescription(action.getDescription(), id);
        return actionRepo.findActionById(id);
    }
}
