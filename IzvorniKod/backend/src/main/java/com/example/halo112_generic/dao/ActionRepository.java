package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    @Query("SELECT r FROM Action r where r.id = :id")
    Optional<Action> findActionById(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Action k SET k.location = :location_id WHERE k.id = :id")
    void editActionLocation(@Param("location_id") Long location_id, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Action k SET k.urgency = :urgency WHERE k.id = :id")
    void editActionUrgency(@Param("urgency") int urgency, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Action k SET k.description = :description WHERE k.id = :id")
    void editActionDescription(@Param("description") String desc, @Param("id") Long id);

}
