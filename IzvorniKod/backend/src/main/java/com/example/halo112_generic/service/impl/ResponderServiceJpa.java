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
    public Optional<Responder> editResponder(Long id, Responder responder) {
        if(responder.getId()!=null) responderRepo.editResponderUser(responder.getId(),id);
        if(responder.getLocation().getId()!=null) responderRepo.editResponderLocation(responder.getLocation().getId(),id);
        if(responder.getStation().getId()!=null) responderRepo.editResponderStation(responder.getStation().getId(), id);
        if(responder.getCurrentAction().getId()!=null) responderRepo.editResponderAction(responder.getCurrentAction().getId(),id);
        responderRepo.editResponderIsDirector(responder.isDirector(), id);
        responderRepo.editResponderStatus(responder.isStatus(),id);

        return responderRepo.findResponderById(id);
    }
    
    @Override
	public boolean acceptAction(Action action, Long id) {
		if (responderRepo.existsById(id)) {
			Responder responder = responderRepo.findById(id).get();
			responder.setCurrentAction(action);
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
	public boolean setStation(Station station, Long id) {
		if (responderRepo.existsById(id)) {
			Responder responder = responderRepo.findById(id).get();
			responder.setStation(station);;
			responderRepo.save(responder);
			return true;
		}
		return false;
	}
}
