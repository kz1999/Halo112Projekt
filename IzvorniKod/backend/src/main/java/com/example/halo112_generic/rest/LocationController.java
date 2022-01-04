package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.LocationRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Location;
import com.example.halo112_generic.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lokacija")
public class LocationController {

    @Autowired
    LocationRepository locationRepo;

    @Autowired
    LocationService locationService;

    @GetMapping("/")
    public List<Location> listLocations() throws Exception {
        return locationService.listAll();
    }

}
