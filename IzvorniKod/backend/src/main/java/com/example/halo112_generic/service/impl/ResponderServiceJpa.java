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
        return responderRepo.findResponderById(id);
    }
}
