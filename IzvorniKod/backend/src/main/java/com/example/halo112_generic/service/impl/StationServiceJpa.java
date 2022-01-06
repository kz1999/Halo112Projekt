package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.StationRepository;
import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StationServiceJpa implements StationService {

    @Autowired
    private StationRepository stationRepo;

    @Override
    //@Secured("ROLE_ADMIN")
    public List<Station> listAll(){
        return stationRepo.findAll();
    }

    @Override
    public Station createStation(Station station) throws Exception {
        return stationRepo.save(station);
    }

    @Override
    public Optional<Station> editStation(Long id, Station station) throws Exception {
        if(station.getDirector_id()!=0) stationRepo.editStationDirector(station.getDirector_id(), id);
        if(station.getLocation_id()!=0) stationRepo.editStationLocation(station.getLocation_id(), id);
        if(station.getType().toString()!="") stationRepo.editStationType(station.getType(), id);
        return stationRepo.findStationById(id);
    }

    @Override
    public Optional<Station> findById(Long id) {
        return stationRepo.findStationById(id);
    }
}
