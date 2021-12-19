package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.domain.StationType;
import com.example.halo112_generic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
	
	String findByName(String name);

    @Query("SELECT r FROM Station r where r.id = :id")
    Optional<Station> findStationById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Station k SET k.director = :director_id WHERE k.id = :id")
    void editStationDirector(@Param("director_id") Long director_id,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Station k SET k.location = :location_id WHERE k.id = :id")
    void editStationLocation(@Param("location_id") Long location_id,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Station k SET k.type = :type WHERE k.id = :id")
    void editStationType(@Param("type")StationType type, @Param("id") Long id);
}
