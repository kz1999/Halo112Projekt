package com.example.halo112_generic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Police;

@Repository
public interface PoliceRepository extends JpaRepository<Police, Long>{

}
