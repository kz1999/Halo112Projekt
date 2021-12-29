package com.example.halo112_generic.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.ActionService;
import com.example.halo112_generic.service.DispatcherService;

@RestController
@RequestMapping("/dispatcher")
public class DispatcherController {
	
	@Autowired
	private DispatcherService dispatcherService;
	
	@Autowired
	private ActionService actionService;
	
	@GetMapping("/create")
	public Action createAction(@RequestBody Action action) throws Exception {
		return actionService.createAction(action);
	}
	
	@PostMapping("/add")
	public boolean addResponderToAction(@RequestBody Responder responder, @RequestBody Long id) throws Exception {
		return actionService.addResponderToAction(responder, id);
	}
	
	@PostMapping("/remove")
	public boolean removeResponderFromAction(@RequestBody Long actionID, @RequestBody Long responderID) throws Exception {
		return actionService.removeResponderFromAction(actionID, responderID);
	}
	
	@PostMapping("/edit")
	// @Secured("ROLE_ADMIN")
	public Action editAction(@RequestBody Action action) throws Exception {
		return actionService.editAction(action);
	}

}
