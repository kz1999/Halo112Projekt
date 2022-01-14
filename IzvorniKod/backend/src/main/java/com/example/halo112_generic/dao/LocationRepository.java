package com.example.halo112_generic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.halo112_generic.domain.Location;

import javax.transaction.Transactional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

    @Transactional
    @Modifying
    @Query("UPDATE Location k SET k.name = :name WHERE k.id = :id")
    void editLocationName(@Param("name") String name, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Location k SET k.x = :x WHERE k.id = :id")
    void editLocationX(@Param("x") double x, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Location k SET k.y = :y WHERE k.id = :id")
    void editLocationY(@Param("y") double y, @Param("id") Long id);
}
