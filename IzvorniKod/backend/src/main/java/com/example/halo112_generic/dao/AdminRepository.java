package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT r FROM Admin r where r.id = :id")
    Optional<Admin> findAdminById(@Param("id")Long id);

}
