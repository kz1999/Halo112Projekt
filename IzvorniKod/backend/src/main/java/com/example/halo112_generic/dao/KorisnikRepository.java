package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Korisnik;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository
        extends JpaRepository<Korisnik, Long> {

}
