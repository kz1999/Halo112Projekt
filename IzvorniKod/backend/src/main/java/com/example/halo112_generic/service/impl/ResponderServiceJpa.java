package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.User;
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
	public Optional<Responder> findByUserId(Long id) {
		return responderRepo.findResponderByUserId(id);
	}

    @Override
    public Optional<Responder> editResponder(Long id, Responder responder) {
        if(responder.getUser_id()!=null) responderRepo.editResponderUser(responder.getUser_id(),id);
        if(responder.getLocation_id()!=null) responderRepo.editResponderLocation(responder.getLocation_id(),id);
        if(responder.getStation_id()!=null) responderRepo.editResponderStation(responder.getStation_id(), id);
        if(responder.getCurrentAction_id()!=null) responderRepo.editResponderAction(responder.getCurrentAction_id(),id);
        responderRepo.editResponderIsDirector(responder.isDirector(), id);
        responderRepo.editResponderStatus(responder.isStatus(),id);

        return responderRepo.findResponderById(id);
    }
    
    @Override
	public boolean acceptAction(Long action_id, Long id) {
		if (responderRepo.existsById(id)) {
			Responder responder = responderRepo.findById(id).get();
			responder.setCurrentAction_id(action_id);
			responderRepo.save(responder);
			return true;
		}
		return false;
	}

	@Override
	public boolean setStatus(boolean status, Long id) {
		if (responderRepo.existsById(id)) {
			Responder responder = responderRepo.findById(id).get();
			responder.setStatus(status);;
			responderRepo.save(responder);
			return true;
		}
		return false;
	}

	@Override
	public boolean setStation(Long station_id, Long id) {
		if (responderRepo.existsById(id)) {
			Responder responder = responderRepo.findById(id).get();
			responder.setStation_id(station_id);;
			responderRepo.save(responder);
			return true;
		}
		return false;
	}
}
