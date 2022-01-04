package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.LocationRepository;
import com.example.halo112_generic.domain.Location;
import com.example.halo112_generic.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LocationServiceJpa implements LocationService {
    @Autowired
    LocationRepository locationRepo;

    @Override
    public List<Location> listAll() {
        return locationRepo.findAll();
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepo.findById(id);
    }

    @Override
    public Optional<Location> editLocation(Long id, Location location) {
        if(location.getName()!=null) locationRepo.editLocationName(location.getName(),id);
        locationRepo.editLocationX(location.getX(), id);
        locationRepo.editLocationY(location.getY(), id);
        return locationRepo.findById(id);
    }
}
