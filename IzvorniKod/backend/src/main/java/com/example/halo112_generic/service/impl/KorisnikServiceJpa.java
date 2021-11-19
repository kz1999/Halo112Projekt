package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.KorisnikRepository;
import com.example.halo112_generic.domain.Korisnik;
import com.example.halo112_generic.service.KorisnikService;
import com.example.halo112_generic.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class KorisnikServiceJpa implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    //@Autowired
    //private PasswordEncoder pswdEncoder;

    @Override
    //@Secured("ROLE_ADMIN")
    public List<Korisnik> listAll(){
        return korisnikRepo.findAll();
    }

    private static final String KORISNICKO_FORMAT = "[]{8,30}";

    @Override
    //@Secured("ROLE_ADMIN")
    public Korisnik createKorisnik(Korisnik korisnik) throws Exception{
        Assert.notNull(korisnik, "Korisnik object must be given");
        //Assert.isNull(korisnik.getId(), "Korisnik ID must be null, not " + korisnik.getId());
        Assert.notNull(korisnik.getKorisnickoIme(), "Korisnik must have KoriskickoIme");
        String korisnickoIme = korisnik.getKorisnickoIme();
        Assert.hasText(korisnickoIme, "KorisnickoIme must be given");
        Assert.isTrue(korisnickoIme.length()<=30,
                "KorisnickoIme must have at least 8 characters not " + korisnickoIme);
        if(korisnikRepo.countByKorisnickoIme(korisnik.getKorisnickoIme())>0)
            throw new RequestDeniedException(
                    "Korisnik with KorisnickoIme " + korisnik.getKorisnickoIme() + " already exists"
            );
        //korisnik.setHashLozinke(pswdEncoder.encode(korisnik.getHashLozinke()));
        return korisnikRepo.save(korisnik);
    }

    @Override
    //@Secured("ROLE_ADMIN")
    public Optional<Korisnik> findByKorisnickoIme(String korisnickoIme) {
        return korisnikRepo.findKorisnikByKorisnickoIme(korisnickoIme);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public Optional<Korisnik> editKorisnik(String korisnickoIme, Korisnik korisnik) {
        if(korisnik.getIme()!=null) korisnikRepo.editKorisnikIme(korisnickoIme, korisnik.getIme());
        if(korisnik.getPrezime()!=null) korisnikRepo.editKorisnikPrezime(korisnickoIme, korisnik.getPrezime());
        if(korisnik.getEmail()!=null) korisnikRepo.editKorisnikEmail(korisnickoIme,korisnik.getEmail());
        if(korisnik.getUloga()!=null) korisnikRepo.editKorisnikUloga(korisnickoIme,korisnik.getUloga());
        if(korisnik.getFotografija()!=null) korisnikRepo.editKorisnikFotografija(korisnickoIme,korisnik.getFotografija());
        if(korisnik.getBrojMobitela()!=null) korisnikRepo.editKorisnikBrojMobitela(korisnickoIme, korisnik.getBrojMobitela());
        if(korisnik.getHashLozinke()!=null) korisnikRepo.editKorisnikHashLozinka(korisnickoIme, korisnik.getHashLozinke());
        korisnikRepo.editKorisnikPotvrden(korisnickoIme,korisnik.isPotvrden());

        return korisnikRepo.findKorisnikByKorisnickoIme(korisnickoIme);
    }
}
