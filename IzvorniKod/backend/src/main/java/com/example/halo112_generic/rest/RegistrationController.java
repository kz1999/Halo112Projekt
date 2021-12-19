package com.example.halo112_generic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
    private UserRepository userRepo;
	
	@PostMapping
	public ResponseEntity<String> processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPasswordHash());
	    user.setPasswordHash(encodedPassword);
	    user.setConfirmed(false);
	    userRepo.save(user);
	    System.out.println(user.toString());

	    return new ResponseEntity<>("register success", HttpStatus.ACCEPTED);
	}
}
