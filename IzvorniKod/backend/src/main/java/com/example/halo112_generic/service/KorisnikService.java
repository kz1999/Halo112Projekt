package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Korisnik;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
//import java.util.Optional;

@Component
public interface KorisnikService {
    List<Korisnik> listAll();

    Korisnik createKorisnik(Korisnik korisnik);

    //Optional<Korisnik> findByKorisnickoIme(String korisnickoIme);
}
