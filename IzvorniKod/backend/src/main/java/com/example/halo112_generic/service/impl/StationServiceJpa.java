package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.dao.StationRepository;
import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class StationServiceJpa implements StationService {

    @Autowired
    private StationRepository stationRepo;

    @Autowired
    private ResponderRepository responderRepo;

    @Override
    //@Secured("ROLE_ADMIN")
    public List<Station> listAll(){
        return stationRepo.findAll();
    }

    @Override
    public Station createStation(Station station) throws Exception {
        Station station1 = stationRepo.save(station);
        Responder responder = responderRepo.findResponderById(station.getDirector_id()).get();
        responder.setDirector(true);
        responder.setStation_id(station.getId());
        responderRepo.save(responder);
        return station1;
    }

    @Override
    public Optional<Station> editStation(Long id, Station station) throws Exception {
        if(station.getDirector_id()!=null){
            Station thisStation = stationRepo.findStationById(id).get();
            Long thisDirectorId = thisStation.getDirector_id();
            Responder thisResponder = responderRepo.getById(thisDirectorId);
            thisResponder.setDirector(false); //miče se status direktora
            responderRepo.save(thisResponder);

            Responder newResponder = responderRepo.getById(station.getDirector_id());
            newResponder.setDirector(true); //mijenja se status direktora i
            newResponder.setStation_id(thisStation.getId());  //id stanice sa respondera (novog directora)
            responderRepo.save(newResponder);

            stationRepo.editStationDirector(station.getDirector_id(), id);
        }
        if(station.getLocation_id()!=null) stationRepo.editStationLocation(station.getLocation_id(), id);
        if(station.getType()!=null) stationRepo.editStationType(station.getType(), id);
        return stationRepo.findStationById(id);
    }


    @Override
    public Optional<Station> findById(Long id) {
        return stationRepo.findStationById(id);
    }

    @Override
    public Station addMember(Long id, Long member_id) {    	
    	Station station = findById(id).get();
    	List<Long> listMembers = station.getMembers();
    	if (!listMembers.contains(member_id)) {
    		listMembers.add(member_id);
    	}

        Responder newResponder = responderRepo.getById(member_id);
        newResponder.setStation_id(id);  //id stanice se zapisuje u member-a
        responderRepo.save(newResponder);

        stationRepo.save(station);
        return station;
    }
}
