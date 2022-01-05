package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.domain.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.DispatcherRepository;
import com.example.halo112_generic.service.DispatcherService;

import java.util.List;

@Component
public class DispatcherServiceJpa implements DispatcherService{

	@Autowired
    private DispatcherRepository dispatcherRepo;


    @Override
    public Dispatcher createDispatcher(Dispatcher dispatcher) {
        return dispatcherRepo.save(dispatcher);
    }

    @Override
    public List<Dispatcher> listAll() {
        return dispatcherRepo.findAll();
    }
}
