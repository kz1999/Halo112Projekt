package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.*;
import com.example.halo112_generic.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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

	@PostMapping("/edit")
	// @Secured("ROLE_ADMIN")
	public Action editAction(@RequestBody Action action) throws Exception {
		return actionService.editAction(action);
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

	@GetMapping("/gallery/{id}")
	// @Secured("ROLE_ADMIN")
	public List<String> displayImages(@PathVariable Long id) throws Exception {
		return actionService.displayImages(id);
	}
	
	@PostMapping("/gallery/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean addImage(@RequestBody String imageUrl, @PathVariable Long id) throws Exception {
		return actionService.addImage(imageUrl, id);
	}

	@GetMapping("/tasks/{id}")
	// @Secured("ROLE_ADMIN")
	public List<Task> displayTasks(@PathVariable Long id) throws Exception {
		return actionService.displayTasks(id);
	}
	@PostMapping("/tasks/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean addTask(@RequestBody Task task, @PathVariable Long id) throws Exception {
		return actionService.addTask(task.getId(), id);
	}

	@GetMapping("/team/{id}")
	public List<Responder> displayResponders(@PathVariable Long id) throws Exception {
		return actionService.displayResponders(id);
	}

	@PostMapping("/team/{id}")
	public boolean addResponderToTeam(@RequestBody Responder responder, @PathVariable Long id) throws Exception{
		return actionService.addResponderToAction(responder.getId(), id);
	}

	@PostMapping("/team/{action_id}/remove/{responder_id}")
	public boolean removeResponderFromTeam(@PathVariable Long action_id, @PathVariable Long responder_id) throws Exception{
		return actionService.removeResponderFromAction(action_id, responder_id);
	}

	@GetMapping("/location/{id}")
	public Location displayLocation(@RequestBody Long id) throws Exception{
		return actionService.displayLocation(id);
	}

	@PostMapping("/location/{id}")
	public void setLocation(@RequestBody Location location, @PathVariable Long id) throws Exception{
		Long location_id = location.getId();
		System.out.println(location_id);
		actionService.setLocation(location_id,id);
	}

}
