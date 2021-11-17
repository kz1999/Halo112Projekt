package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.Korisnik;
import com.example.halo112_generic.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }

    @PostMapping("")
    //@Secured("ROLE_ADMIN")
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik) throws Exception {
        return korisnikService.createKorisnik(korisnik);
    }

    @GetMapping("/{korisnickoIme}")
    public Korisnik getKorisnik(@PathVariable String korisnickoIme) throws Exception {
        return korisnikService.getKorisnik(korisnickoIme);
    }

    @PostMapping("/{korisnickoIme}")
    public Korisnik editKorisnik(@PathVariable String korisnickoIme, @RequestBody Korisnik korisnik) throws Exception {
        return korisnikService.editKorisnik(korisnickoIme, korisnik);
    }

}
