package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/korisnici")
public class UsersController {

    @Autowired
    private UserService userService;
    
    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<User> listUsers() throws Exception {
        if(!userService.findByUserName("admin").isPresent()){
            User admin = new User((long)1,"admin","","$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy","Adminko","Adminović","","","admin",true);
            
            userService.createUser(admin);
        }
        return userService.listAll();
    }

    @PostMapping("")
    //@Secured("ROLE_ADMIN")
    public User createUser(@RequestBody User user) throws Exception {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPasswordHash());
	    user.setPasswordHash(encodedPassword);
	    user.setConfirmed(false);
	    
        return userService.createUser(user);
    }
    
    /*
    @GetMapping("/fill")
    //@Secured("ROLE_ADMIN")
    public boolean fill() throws Exception {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = null;
    	
    	User user1 = new User("policeman", "/user1photo", "policeman", "user1name", "user1surname", "091", "user1mail", "policeman", true);
	    encodedPassword = passwordEncoder.encode(user1.getPasswordHash());
	    user1.setPasswordHash(encodedPassword);
        userService.createUser(user1);
        
        User user2 = new User("dispatcher", "/user2photo", "dispatcher", "user2name", "user2surname", "091", "user2mail", "dispatcher", true);
	    encodedPassword = passwordEncoder.encode(user2.getPasswordHash());
	    user2.setPasswordHash(encodedPassword);
        userService.createUser(user2);
        
        User user3 = new User("admin", "/user3photo", "admin", "user3name", "user3surname", "091", "user3mail", "admin", true);
	    encodedPassword = passwordEncoder.encode(user3.getPasswordHash());
	    user3.setPasswordHash(encodedPassword);
        userService.createUser(user3);
        
        User user4 = new User("fireman", "/user4photo", "fireman", "user4name", "user4surname", "091", "user4mail", "fireman", true);
	    encodedPassword = passwordEncoder.encode(user4.getPasswordHash());
	    user4.setPasswordHash(encodedPassword);
        userService.createUser(user4);
        
        User user5 = new User("policeman2", "/user5photo", "policeman2", "user5name", "user5surname", "091", "user5mail", "policeman", true);
	    encodedPassword = passwordEncoder.encode(user5.getPasswordHash());
	    user5.setPasswordHash(encodedPassword);
        userService.createUser(user5);
        
        return true;
    }
    */

    @GetMapping("/{userName}")
    //@Secured("ROLE_ADMIN")
    public Optional<User> findByUserName(@PathVariable String userName) throws Exception {
        return userService.findByUserName(userName);
    }

    @PostMapping("/{userName}")
    //@Secured("ROLE_ADMIN")
    public Optional<User> editUser(@PathVariable String userName, @RequestBody User user) throws Exception {
        return userService.editUser(userName, user);
    }

    @GetMapping("/ID/{id}")
    //@Secured("ROLE_ADMIN")
    public Optional<User> findById(@PathVariable Long id) throws Exception {
        return userService.findById(id);
    }

    @GetMapping("/confirm/{id}")
    public boolean confirmUser (@PathVariable Long id) throws Exception {
        return userService.confirmUser(id);
        //return userService.findById(id).get();
    }

}
