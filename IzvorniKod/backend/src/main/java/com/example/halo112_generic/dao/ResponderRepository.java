package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Responder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ResponderRepository extends JpaRepository<Responder, Long> {

    @Query("SELECT r FROM Responder r where r.id = :id")
    Optional<Responder> findResponderById(@Param ("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Respodner k SET k.station_id = :station_id WHERE k.id = :id")
    void editRespodnerStation(@Param("station_id") Long station_id,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Respodner k SET k.status = :status WHERE k.id = :id")
    void editRespodnerStatus(@Param("status") boolean status,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Respodner k SET k.action_id = :action_id WHERE k.id = :id")
    void editRespodnerAction(@Param("action_id") Long action_id, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Respodner k SET k.location_id = :location_id WHERE k.id = :id")
    void editRespodnerLocation(@Param("location_id") Long location_id, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Respodner k SET k.isDirector = :isDirector WHERE k.id = :id")
    void editRespodnerIsDirector(@Param("isDirector") boolean isDirector, @Param("id") Long id);
}
