package com.example.halo112_generic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.domain.Location;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.StationType;
import com.example.halo112_generic.service.AdminService;
import com.example.halo112_generic.service.StationService;
import com.example.halo112_generic.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private StationService stationService;

	@PostMapping("/confirm/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean confirmUser(@PathVariable Long id) throws Exception {
		return userService.confirmUser(id);
	}

	@PostMapping("/deny/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean denyUser(@PathVariable Long id) throws Exception {
		return userService.denyUser(id);
	}

	@PostMapping("/create_station")
	// @Secured("ROLE_ADMIN")
	public Station createStation(@RequestBody String name, @RequestBody Long director,
			@RequestBody Long location, @RequestBody StationType type) throws Exception {
		return stationService.createStation(new Station(name, director, location, type));
	}
	
	@PostMapping("/privilege/{id}")
	// @Secured("ROLE_ADMIN")
	public boolean changePrivilege(@RequestBody String privilege, @PathVariable Long id) throws Exception {
		return userService.changePrivilege(privilege, id);
	}

}
