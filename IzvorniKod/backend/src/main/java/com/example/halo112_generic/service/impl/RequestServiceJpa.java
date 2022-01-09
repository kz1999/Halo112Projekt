package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.RequestRepository;
import com.example.halo112_generic.domain.Request;
import com.example.halo112_generic.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RequestServiceJpa implements RequestService {

    @Autowired
    private RequestRepository requestRepo;

    @Override
    public List<Request> listAll() {
        return requestRepo.findAll();
    }

    @Override
    public Request createRequest(Request responder) {
        return requestRepo.save(responder);
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
