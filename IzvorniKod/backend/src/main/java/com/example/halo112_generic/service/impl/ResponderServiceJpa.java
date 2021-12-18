package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
        if(responder.getLocation().getId()!=null) responderRepo.editRespodnerLocation(responder.getLocation().getId(),id);
        if(responder.getStation().getId()!=null) responderRepo.editRespodnerStation(responder.getStation().getId(), id);
        if(responder.getCurrentAction().getId()!=null) responderRepo.editRespodnerAction(responder.getCurrentAction().getId(),id);
        responderRepo.editRespodnerIsDirector(responder.isDirector(), id);
        responderRepo.editRespodnerStatus(responder.isStatus(),id);

        return responderRepo.findResponderById(id);
    }
}
