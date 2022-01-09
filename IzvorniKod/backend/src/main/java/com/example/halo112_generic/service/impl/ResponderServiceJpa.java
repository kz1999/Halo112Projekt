package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ActionRepository;
import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.*;
import com.example.halo112_generic.service.ActionService;
import com.example.halo112_generic.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ResponderServiceJpa implements ResponderService {

    @Autowired
    private ResponderRepository responderRepo;

	@Autowired
	private ActionRepository actionRepo;

	@Autowired
	private ActionService actionService;

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
	public boolean acceptRequest(Long id, Long request_id) {
		Responder responder = responderRepo.getById(id);
		boolean found=false;
		Request r = null;
		for(var request : responder.getRequestsList()) {
			if (request.getId() == request_id) {
				found = true;
				r = request;
				if(responder.getCurrentAction_id()==null){
					responder.setCurrentAction_id(r.getAction_id());
					actionService.addResponderToAction(r.getAction_id(),responder.getId());
				}
				else{
					Long oldAction = responder.getCurrentAction_id();
					Long newAction = r.getAction_id();
					actionService.removeResponderFromAction(oldAction, responder.getId());
					actionService.addResponderToAction(newAction, responder.getId());
					responder.setCurrentAction_id(newAction);
				}
			}
		}
		if(found && r!=null) {
			responder.getRequestsList().remove(r);
			responderRepo.save(responder);
		}
		return found;
	}

	@Override
	public boolean rejectRequest(Long id, Long request_id) {
		Responder responder = responderRepo.getById(id);
		boolean found=false;
		Request r=null;
		for(var request : responder.getRequestsList()) {
			if (request.getId() == request_id) {
				found = true;
				r = request;
			}
		}
		if(found && r!=null) {
			responder.getRequestsList().remove(r);
			responderRepo.save(responder);
		}

		return found;
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
