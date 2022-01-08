package com.example.halo112_generic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.TaskRepository;
import com.example.halo112_generic.domain.Task;
import com.example.halo112_generic.service.TaskService;

@Component
public class TaskServiceJpa implements TaskService{
	@Autowired
    private TaskRepository taskRepo;

	@Override
	public List<Task> list() {
		 return taskRepo.findAll();
	}

	@Override
	public Task save(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public Optional<Task> findById(Long id) {
		return taskRepo.findById(id);
	}

}
