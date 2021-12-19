package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ResponderServiceJpa implements ResponderService {

    @Autowired
    private ResponderRepository responderRepo;

    @Override
    public List<Responder> listAll() {
        return responderRepo.findAll();
    }

    @Override
    public Responder createResponder(Responder responder) {
        return responderRepo.save(responder);
    }

    @Override
    public Optional<Responder> findById(Long id) {
        return responderRepo.findResponderById(id);
    }

    @Override
    public Optional<Responder> editResponder(Long id, Responder responder) {
        if(responder.getUser().getId()!=null) responderRepo.editResponderUser(responder.getUser().getId(),id);
        if(responder.getLocation().getId()!=null) responderRepo.editResponderLocation(responder.getLocation().getId(),id);
        if(responder.getStation().getId()!=null) responderRepo.editResponderStation(responder.getStation().getId(), id);
        if(responder.getCurrentAction().getId()!=null) responderRepo.editResponderAction(responder.getCurrentAction().getId(),id);
        responderRepo.editResponderIsDirector(responder.isDirector(), id);
        responderRepo.editResponderStatus(responder.isStatus(),id);

        return responderRepo.findResponderById(id);
    }
}
