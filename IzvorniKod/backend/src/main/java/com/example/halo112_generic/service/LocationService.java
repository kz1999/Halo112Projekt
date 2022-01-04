package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService{
    List<Location> listAll();

    Location createLocation(Location location);

    Optional<Location> findById(Long id);

    Optional<Location> editLocation(Long id, Location location);
}
