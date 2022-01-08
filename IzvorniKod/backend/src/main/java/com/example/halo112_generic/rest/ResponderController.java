package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.ActionService;
import com.example.halo112_generic.service.ResponderService;
import com.example.halo112_generic.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spasioci")
public class ResponderController {
    @Autowired
    private ResponderService responderService;
    
    @Autowired
    private ActionService actionService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<Responder> listResponders() throws Exception {
        return responderService.listAll();
    }

    @PostMapping("")
    public Responder createResponder(@RequestBody Responder responder) throws Exception {
        return responderService.createResponder(responder);
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

    @GetMapping("/{id}")
    //@Secured("ROLE_ADMIN")
    public Optional<Responder> findById(@PathVariable Long id) throws Exception {
        return responderService.findById(id);
    }

    @PostMapping("/{id}")
    //@Secured("ROLE_ADMIN")
    public Optional<Responder> editResponder(@PathVariable Long id, @RequestBody Responder responder) throws Exception {
        return responderService.editResponder(id, responder);
    }
    
    @PostMapping("/accept/{id}")
    public boolean acceptAction(@RequestBody Action action, @PathVariable Long id) throws Exception {
        return responderService.acceptAction(action.getId(), id);
    }
    
    @PostMapping("/reject/{id}")
    public boolean rejectAction(@RequestBody Action action, @PathVariable Long id) throws Exception {
        return actionService.rejectAction(action, id);
    }
    
    @PostMapping("/status/{id}")
    public boolean setStatus(@RequestBody boolean status, @PathVariable Long id) throws Exception {
        return responderService.setStatus(status, id);
    }
    
    @PostMapping("/station/{id}")
    public boolean setStation(@RequestBody Station station, @PathVariable Long id) throws Exception {
        return responderService.setStation(station.getId(), id);
    }
}
