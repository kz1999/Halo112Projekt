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
        Request req = requestRepo.findById(request.getId()).get();
        for(var responder: responderRepo.findAll()){
            if(responder.getResponderAbility()!=null && responder.getResponderAbility().equals(req.getResponderAbility()) && responder.isStatus()==true) {
                responder.getRequestsList().add(req.getId());
                responderRepo.save(responder);
            }
        }
        return req;
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
