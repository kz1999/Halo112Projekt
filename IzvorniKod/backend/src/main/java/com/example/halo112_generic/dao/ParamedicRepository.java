package com.example.halo112_generic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.halo112_generic.domain.Paramedic;

@Repository
public interface ParamedicRepository extends JpaRepository<Paramedic, Long>{

}
