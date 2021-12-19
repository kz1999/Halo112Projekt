package com.example.halo112_generic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

}
