package com.example.halo112_generic.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Comment;
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

	@Override
	public List<Comment> displayComments(Long id) {
		if (taskRepo.existsById(id)) {
			return taskRepo.findById(id).get().getComments();
		}
		return null;
	}

	@Override
	public boolean addComment(Comment comment, Long id) {
		if (taskRepo.existsById(id)) {
			Task task = taskRepo.findById(id).get();
			task.getComments().add(comment);
			taskRepo.save(task);
			return true;
		}
		return false;
	}

}
