package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spasioci")
public class ResponderController {
    @Autowired
    private ResponderService responderService;

    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<Responder> listResponders() throws Exception {
        return responderService.listAll();
    }

    @PostMapping("")
    public Responder createResponder(@RequestBody Responder responder) throws Exception {
        return responderService.createResponder(responder);
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
}
