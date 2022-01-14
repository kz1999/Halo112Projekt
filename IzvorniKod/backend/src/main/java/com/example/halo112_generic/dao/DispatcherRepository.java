package com.example.halo112_generic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.halo112_generic.domain.Dispatcher;

@Repository
public interface DispatcherRepository  extends JpaRepository<Dispatcher, Long>{

}
