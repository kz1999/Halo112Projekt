package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.RequestRepository;
import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.Request;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.RequestService;
import com.example.halo112_generic.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RequestServiceJpa implements RequestService {

    @Autowired
    private RequestRepository requestRepo;

    @Autowired
    private ResponderService responderService;

    @Autowired
    private ResponderRepository responderRepo;

    @Override
    public List<Request> listAll() {
        return requestRepo.findAll();
    }

    @Override
    public Request createRequest(Request request) {
        requestRepo.save(request);
        //List<Responder> responderList = new ArrayList<Responder>();
        for(var responder: responderRepo.findAll()){
            responder.getRequestsList().add(request.getId());
            responderRepo.save(responder);
        }
        return requestRepo.findById(request.getId()).get();
    }

    @Override
    public Optional<Request> findById(Long id) {
        return requestRepo.findById(id);
    }

    @Override
    public void removeById(Long id) {
        requestRepo.deleteById(id);
    }
}
