package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/korisnici")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;
    
    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<User> listUsers() throws Exception {
        if(!userService.findByUserName("admin").isPresent()){
            User admin = new User((long)1,"admin","","$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy","Adminko","Adminović","","","",true);
            userService.createUser(admin);
            userRepo.save(admin);
        }
        return userService.listAll();
    }

    @PostMapping("")
    //@Secured("ROLE_ADMIN")
    public User createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }

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

}
