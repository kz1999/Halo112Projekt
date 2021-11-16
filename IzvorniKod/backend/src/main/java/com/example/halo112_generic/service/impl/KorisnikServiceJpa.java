package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.KorisnikRepository;
import com.example.halo112_generic.domain.Korisnik;
import com.example.halo112_generic.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

@Component
public class KorisnikServiceJpa implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    @Override
    public List<Korisnik> listAll(){
        return korisnikRepo.findAll();
    }

    @Override
    public Korisnik createKorisnik(Korisnik korisnik){
        Assert.notNull(korisnik, "Student object must be given");
        Assert.isNull(korisnik.getId(), "Student ID must be null, not " + korisnik.getId());
        return korisnikRepo.save(korisnik);
    }
}
