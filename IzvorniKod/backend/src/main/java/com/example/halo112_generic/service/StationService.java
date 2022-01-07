package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Station;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StationService {
    List<Station> listAll();

    Station createStation(Station station) throws Exception;

    Optional<Station> editStation(Long id, Station station) throws Exception;

    Optional<Station> findById(Long id);

    public Station addMember(Long id, Long member_id);

}
