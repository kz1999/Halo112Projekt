package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Action;

import java.util.List;
import java.util.Optional;

public interface ActionService {
    List<Action> listAll();

    Action createAction(Action action);

    Optional<Action> findById(Long id);

    Optional<Action> editAction(Long id, Action action);
}
