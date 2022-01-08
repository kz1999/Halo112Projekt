package com.example.halo112_generic.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.Task;
import com.example.halo112_generic.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("")
	// @Secured("ROLE_ADMIN")
	public List<Task> list() throws Exception {
		return taskService.list();
	}

	@PostMapping("")
	public Task create(@RequestBody Task task) throws Exception {
		return taskService.save(task);
	}

	@PostMapping("/edit")
	// @Secured("ROLE_ADMIN")
	public Task edit(@RequestBody Task task) throws Exception {
		return taskService.save(task);
	}

	@GetMapping("/{id}")
	// @Secured("ROLE_ADMIN")
	public Optional<Task> findById(@PathVariable Long id) throws Exception {
		return taskService.findById(id);
	}

}
