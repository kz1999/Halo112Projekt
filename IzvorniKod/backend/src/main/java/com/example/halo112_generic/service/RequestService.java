package com.example.halo112_generic.service;


import com.example.halo112_generic.domain.Request;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface RequestService {
    List<Request> listAll();

    Request createRequest(Request responder);

    Optional<Request> findById(Long id);

    void removeById(Long id);

    //Optional<Request> editRequest(Long id, Request responder);
}
