package com.example.halo112_generic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.halo112_generic.domain.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Long>{

}
