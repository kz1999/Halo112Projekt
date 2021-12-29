package com.example.halo112_generic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.TaskRepository;
import com.example.halo112_generic.service.TaskService;

@Component
public class TaskServiceJpa implements TaskService{
	@Autowired
    private TaskRepository taskRepo;

}
