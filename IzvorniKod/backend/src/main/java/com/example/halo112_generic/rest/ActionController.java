package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Comment;
import com.example.halo112_generic.domain.Task;
import com.example.halo112_generic.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/akcije")
public class ActionController {

	@Autowired
	private ActionService actionService;

	@GetMapping("")
	// @Secured("ROLE_ADMIN")
	public List<Action> listActions() throws Exception {
		return actionService.listAll();
	}

	@PostMapping("")
	public Action createAction(@RequestBody Action action) throws Exception {
		return actionService.createAction(action);
	}

	@GetMapping("/{id}")
	// @Secured("ROLE_ADMIN")
	public Optional<Action> findById(@PathVariable Long id) throws Exception {
		return actionService.findById(id);
	}

	@GetMapping("/close/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean closeAction(@PathVariable Long id) throws Exception {
		return actionService.closeAction(id);
	}

	@PostMapping("/close")
	// @Secured("ROLE_ADMIN")
	public boolean addTask(@RequestBody Task task, @RequestBody Long id) throws Exception {
		return actionService.addTask(task, id);
	}

	@GetMapping("/comments/{id}")
	// @Secured("ROLE_ADMIN")
	public List<Comment> displayComments(@PathVariable Long id) throws Exception {
		return actionService.displayComments(id);
	}
	
	@PostMapping("/comments/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean addComment(@RequestBody Comment comment, @PathVariable Long id) throws Exception {
		return actionService.addComment(comment, id);
	}
	
	@PostMapping("/image/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean addImage(@RequestBody String imageUrl, @PathVariable Long id) throws Exception {
		return actionService.addImage(imageUrl, id);
	}

	@PostMapping("/edit")
	// @Secured("ROLE_ADMIN")
	public Action editAction(@RequestBody Action action) throws Exception {
		return actionService.editAction(action);
	}
}
