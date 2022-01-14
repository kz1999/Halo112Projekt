package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.Station;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public interface ResponderService {
    List<Responder> listAll();

    Responder createResponder(Responder responder);

    Optional<Responder> findById(Long id);

    Optional<Responder> editResponder(Long id, Responder responder);

	boolean acceptAction(Long action_id, Long id);

	boolean setStatus(boolean status, Long id);

	boolean setStation(Long station_id, Long id);

    Optional<Responder> findByUserId(Long id);

    boolean acceptRequest(Long id, Long request_id);

    boolean rejectRequest(Long id, Long request_id);
}
