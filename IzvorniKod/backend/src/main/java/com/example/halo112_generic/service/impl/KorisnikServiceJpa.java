package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.KorisnikRepository;
import com.example.halo112_generic.domain.Korisnik;
import com.example.halo112_generic.service.KorisnikService;
import com.example.halo112_generic.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

@Component
public class KorisnikServiceJpa implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    @Override
    public List<Korisnik> listAll(){
        return korisnikRepo.findAll();
    }

    private static final String KORISNICKO_FORMAT = "[]{8,30}";

    @Override
    public Korisnik createKorisnik(Korisnik korisnik) throws Exception{
        Assert.notNull(korisnik, "Student object must be given");
        Assert.isNull(korisnik.getId(), "Student ID must be null, not " + korisnik.getId());
        Assert.notNull(korisnik.getKorisnickoIme(), "Korisnik must have KoriskickoIme");
        String korisnickoIme = korisnik.getKorisnickoIme();
        Assert.hasText(korisnickoIme, "KorisnickoIme must be given");
        Assert.isTrue(korisnickoIme.length()>=8,
                "KorisnickoIme must have at least 8 characters not " + korisnickoIme);
        if(korisnikRepo.countByKorisnickoIme(korisnik.getKorisnickoIme())>0)
            throw new RequestDeniedException(
                    "Korisnik with KorisnickoIme " + korisnik.getKorisnickoIme() + " already exists"
            );
        return korisnikRepo.save(korisnik);
    }
}
