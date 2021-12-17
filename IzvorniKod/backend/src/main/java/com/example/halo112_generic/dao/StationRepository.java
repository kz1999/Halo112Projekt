package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    @Query("SELECT r FROM Station r where r.id = :id")
    Optional<Station> findStationById(@Param("id") Long id);
}
