package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Action;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ActionService {
    List<Action> listAll();

    Action createAction(Action action);

    Optional<Action> findById(Long id);

    Optional<Action> editAction(Long id, Action action);
}
