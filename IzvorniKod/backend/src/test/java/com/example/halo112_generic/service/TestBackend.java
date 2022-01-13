package com.example.halo112_generic.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Comment;
import com.example.halo112_generic.domain.Location;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.StationType;
import com.example.halo112_generic.domain.Task;
import com.example.halo112_generic.domain.User;

@SpringBootTest
public class TestBackend {
	@Autowired
    private UserService userService;
	
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
    private ResponderService responderService;
	
	@Autowired
    private StationService stationService;
	
	@Autowired
    private DispatcherService dispatcherService;
		
	@Autowired
    private ActionService actionService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private TaskService taskService;
		
	@Autowired
	private FiremanService firemanService;
		
	@Test
	public void testUser() throws Exception {
		userService.createUser(new User(null, "test1", "", "secret", "Test", "Test", "", "", "policeman", false));
		
		assertTrue(userRepo.findUserByUserName("test1").isPresent());
		User user = userRepo.findUserByUserName("test1").get();
		assertFalse(user.isConfirmed());
		assertTrue(userService.confirmUser(user.getId()));
		user = userRepo.findById(user.getId()).get();
		assertTrue(user.isConfirmed());
	}
	
	@Test
	public void testRole() throws Exception {
		User user1 = userService.createUser(new User(null, "test2", "", "secret", "Test", "Test", "", "", "fireman", true));
		Responder responder = responderService.findByUserId(user1.getId()).get();
		assertEquals("test2", responder.getUserName());
		assertEquals(responder.getId(), firemanService.listAll().get(0).getResponder());
		
		User user2 = userService.createUser(new User(null, "test3", "", "secret", "Test", "Test", "", "", "dispatcher", true));
		assertEquals(user2.getId(), dispatcherService.listAll().get(0).getUser());
	}
	
	@Test
	@Transactional
	public void testAction() throws Exception {
		User user = userService.createUser(new User(null, "test4", "", "secret", "Test", "Test", "", "", "doctor", true));
		Responder responder = responderService.findByUserId(user.getId()).get();
		
		Action act = new Action();
		act.setName("test action");
		act.setDescription("test...");
		act.setTeam(new ArrayList<Responder>());
		act.setTasks(new ArrayList<Task>());
		actionService.createAction(act);
				
		assertTrue(actionService.addResponderToAction(responder.getId(), act.getId()));
		assertTrue(actionService.displayResponders(act.getId()).contains(responder));
		
		assertTrue(actionService.closeAction(act.getId()));
	}
	
	@Test
	@Transactional
	public void testStation() throws Exception {
		User user1 = userService.createUser(new User(null, "test5", "", "secret", "Test", "Test", "", "", "doctor", true));
		Responder director = responderService.findByUserId(user1.getId()).get();
		User user2 = userService.createUser(new User(null, "test6", "", "secret", "Test", "Test", "", "", "doctor", true));
		Responder responder = responderService.findByUserId(user2.getId()).get();
		
		Station station = stationService.createStation(new Station("Test station", director.getId(),
				locationService.createLocation(new Location()).getId(), StationType.HOSPITAL));
		station.setMembers(new ArrayList<Long>());
		station = stationService.addMember(station.getId(), responder.getId());
		
		assertTrue(station.getMembers().contains(responder.getId()));
		assertEquals(station.getDirector_id(), director.getId());
	}
	
	@Test
	@Transactional
	public void testTask() throws Exception {
		User user = userService.createUser(new User(null, "test7", "", "secret", "Test", "Test", "", "", "policeman", true));
		
		Action act = new Action();
		act.setName("test action");
		act.setDescription("test...");
		act.setTeam(new ArrayList<Responder>());
		act.setTasks(new ArrayList<Task>());
		actionService.createAction(act);
		
		Task task = taskService.save(new Task(null, "test task", user.getId(), new ArrayList<Long>(), new ArrayList<Comment>()));
		assertEquals(user.getId(), task.getResponder_id());
		assertTrue(actionService.addTask(task.getId(), act.getId()));
		assertTrue(taskService.addComment(new Comment(), task.getId()));
	}
	
	@Test
	@Transactional
	public void testWrongStationType() throws Exception {
		User user1 = userService.createUser(new User(null, "test8", "", "secret", "Test", "Test", "", "", "policeman", true));
		Responder director = responderService.findByUserId(user1.getId()).get();
		User user2 = userService.createUser(new User(null, "test9", "", "secret", "Test", "Test", "", "", "doctor", true));
		Responder responder = responderService.findByUserId(user2.getId()).get();
		
		Station station = stationService.createStation(new Station("Test station 2", director.getId(),
				locationService.createLocation(new Location()).getId(), StationType.POLICE));
		station.setMembers(new ArrayList<Long>());
		
		assertThrows(IllegalArgumentException.class, () -> stationService.addMember(station.getId(), responder.getId()));
	}
}
