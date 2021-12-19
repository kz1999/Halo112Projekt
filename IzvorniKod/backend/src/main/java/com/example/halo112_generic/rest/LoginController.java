package com.example.halo112_generic.rest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private UserRepository userRepo;
	
    @GetMapping
    public ResponseEntity<String> login() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        if (!auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ANONYMOUS"))) {
        	return new ResponseEntity<>("already logged in as " + username, HttpStatus.FORBIDDEN);
        } else {
        	return new ResponseEntity<>("login page", HttpStatus.OK);
        }
    }
    /*
    @PostMapping
    public ResponseEntity<String> login(HttpServletRequest req, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
    	UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
    	Authentication auth = authManager.authenticate(authReq);
    
    	SecurityContext sc = SecurityContextHolder.getContext();
    	sc.setAuthentication(auth);
    	HttpSession session = req.getSession(true);
    	session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
    }
    */
}
