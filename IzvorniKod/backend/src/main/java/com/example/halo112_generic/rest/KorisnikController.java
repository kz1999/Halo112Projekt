package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.Korisnik;
import com.example.halo112_generic.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("")
    //@Secured("ROLE_ADMIN")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }

    @PostMapping("")
    //@Secured("ROLE_ADMIN")
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik) throws Exception {
        return korisnikService.createKorisnik(korisnik);
    }

    @GetMapping("/{korisnickoIme}")
    //@Secured("ROLE_ADMIN")
    public Optional<Korisnik> findByKorisnickoIme(@PathVariable String korisnickoIme) throws Exception {
        return korisnikService.findByKorisnickoIme(korisnickoIme);
    }

    @PostMapping("/{korisnickoIme}")
    @Secured("ROLE_ADMIN")
    public Optional<Korisnik> editKorisnik(@PathVariable String korisnickoIme, @RequestBody Korisnik korisnik) throws Exception {
        return korisnikService.editKorisnik(korisnickoIme, korisnik);
    }

}
