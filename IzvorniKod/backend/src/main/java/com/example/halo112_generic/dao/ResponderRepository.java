package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Responder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResponderRepository extends JpaRepository<Responder, Long> {

    @Query("SELECT r FROM Responder r where r.id = :id")
    Optional<Responder> findResponderById(@Param ("id") Long id);
}
