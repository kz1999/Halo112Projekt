package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.LocationRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Location;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lokacija")
public class LocationController {

    @Autowired
    LocationRepository locationRepo;

    @Autowired
    LocationService locationService;

    @GetMapping("")
    public List<Location> listLocations() throws Exception {
        return locationService.listAll();
    }

    @PostMapping("")
    public Location createLocation(@RequestBody Location location) throws Exception {
        return locationService.createLocation(location);
    }

    @GetMapping("/{id}")
    //@Secured("ROLE_ADMIN")
    public Optional<Location> findById(@PathVariable Long id) throws Exception {
        return locationService.findById(id);
    }

}
