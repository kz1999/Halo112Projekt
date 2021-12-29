package com.example.halo112_generic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.DispatcherRepository;
import com.example.halo112_generic.service.DispatcherService;

@Component
public class DispatcherServiceJpa implements DispatcherService{

	@Autowired
    private DispatcherRepository dispatcherRepo;
}
