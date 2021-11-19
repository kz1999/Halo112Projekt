package com.example.halo112_generic.rest;

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

    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<User> listUsers() {
        return userService.listAll();
    }

    @PostMapping("")
    //@Secured("ROLE_ADMIN")
    public User createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }

    @GetMapping("/{userName}")
    @Secured("ROLE_ADMIN")
    public Optional<User> findByUserName(@PathVariable String userName) throws Exception {
        return userService.findByUserName(userName);
    }

    @PostMapping("/{userName}")
    @Secured("ROLE_ADMIN")
    public Optional<User> editUser(@PathVariable String userName, @RequestBody User user) throws Exception {
        return userService.editUser(userName, user);
    }

}
