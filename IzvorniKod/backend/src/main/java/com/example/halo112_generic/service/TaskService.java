package com.example.halo112_generic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.Task;

@Component
public interface TaskService {

	List<Task> list();

	Task save(Task task);

	Optional<Task> findById(Long id);

}
