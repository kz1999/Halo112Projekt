package com.example.halo112_generic.dao;


import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResponderRepository extends JpaRepository<Responder, Long> {

    @Query("SELECT r FROM Responder r where r.id = :id")
    Optional<Responder> findResponderById(@Param ("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Responder k SET k.station = :station_id WHERE k.id = :id")
    void editResponderStation(@Param("station_id") Long station_id,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Responder k SET k.status = :status WHERE k.id = :id")
    void editResponderStatus(@Param("status") boolean status,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Responder k SET k.currentAction = :action_id WHERE k.id = :id")
    void editResponderAction(@Param("action_id") Long action_id, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Responder k SET k.location = :location_id WHERE k.id = :id")
    void editResponderLocation(@Param("location_id") Long location_id, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Responder k SET k.isDirector = :isDirector WHERE k.id = :id")
    void editResponderIsDirector(@Param("isDirector") boolean isDirector, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.passwordHash = :userPasswordHash WHERE k.userName = :userName")
    void editUserPasswordHash(@Param("userName") String userName, @Param("userPasswordHash") String userPasswordHash);


}
