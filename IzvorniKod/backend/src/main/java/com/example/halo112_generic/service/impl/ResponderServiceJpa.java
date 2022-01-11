package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ActionRepository;
import com.example.halo112_generic.dao.LocationRepository;
import com.example.halo112_generic.dao.RequestRepository;
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

	@Autowired
	private RequestRepository requestRepo;

	@Autowired
	private LocationRepository locationRepo;

    @Override
    public List<Responder> listAll() {
        return responderRepo.findAll();
    }

    @Override
    public Responder createResponder(Responder responder) {
		Location l = new Location();
		l.setName(responder.getUserName());
		l.setX(0);
		l.setY(0);
		locationRepo.save(l);
		responder.setLocation_id(l.getId());
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
			if (request == request_id) {
				found = true;
				r = requestRepo.getById(request);
				if(responder.getCurrentAction_id()==null){
					responder.setCurrentAction_id(r.getAction_id());
					actionService.addResponderToAction(responder.getId(),r.getAction_id());
				}
				else{
					Long oldAction = responder.getCurrentAction_id();
					Long newAction = r.getAction_id();
					actionService.removeResponderFromAction(responder.getId(),oldAction);
					actionService.addResponderToAction(responder.getId(),newAction);
					responder.setCurrentAction_id(newAction);
				}
			}
		}
		if(found) {
			responder.getRequestsList().remove(request_id);
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
			if (request == request_id) {
				found = true;
				r = requestRepo.getById(request);
			}
		}
		if(found) {
			responder.getRequestsList().remove(request_id);
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
