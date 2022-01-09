package com.example.halo112_generic.rest;

import java.util.List;
import java.util.Optional;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.*;
import com.example.halo112_generic.service.RequestService;
import com.example.halo112_generic.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.halo112_generic.domain.Dispatcher;
import com.example.halo112_generic.service.ActionService;
import com.example.halo112_generic.service.DispatcherService;

@RestController
@RequestMapping("/dispatcher")
public class DispatcherController {
	
	@Autowired
	private DispatcherService dispatcherService;
	
	@Autowired
	private ActionService actionService;

	@Autowired
	private ResponderService responderService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RequestService requestService;

	@GetMapping("")
	public List<Dispatcher> listDispatchers() throws Exception{
		return dispatcherService.listAll();
	}

	@PostMapping("")
	public Dispatcher createDispatcher(@RequestBody Dispatcher dispatcher) throws Exception{
		return dispatcherService.createDispatcher(dispatcher);
	}

	@GetMapping("/current")
	//@Secured("ROLE_USER")
	public Optional<Responder> currentResponder(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		System.out.println(auth.isAuthenticated() + "\n" + username + "\n" + auth.getAuthorities());
		User user = userRepo.findUserByUserName(username).get();
		return responderService.findByUserId(user.getId());
	}

	@GetMapping("/requests")
	public List<Request> listRequests() throws Exception{
		return requestService.listAll();
	}

	@GetMapping("/requests/{id}")
	public Optional<Request> findRequestById(@PathVariable Long id) throws Exception{
		return requestService.findById(id);
	}

	@PostMapping("/createRequest")
	public Request createRequest(@RequestBody Request request) throws Exception{
		return requestService.createRequest(request);
	}

	@PostMapping("/removeRequest/{id}")
	public void removeRequest(@PathVariable Long id){
		requestService.removeById(id);
	}
	
	@PostMapping("/create")
	public Action createAction(@RequestBody Action action) throws Exception {
		return actionService.createAction(action);
	}
	
	@PostMapping("/add")
	public boolean addResponderToAction(@RequestBody Responder responder, @RequestBody Long id) throws Exception {
		return actionService.addResponderToAction(responder.getId(), id);
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

