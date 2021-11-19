package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.KorisnikRepository;
import com.example.halo112_generic.domain.Korisnik;
import com.example.halo112_generic.domain.KorisnikDetails;
import com.example.halo112_generic.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class KorisnikUserDetailsService implements UserDetailsService {
    //@Value("${com.example.halo112_generic.admin.password}")
    //private String adminPasswordHash;

    PasswordEncoder pswdEncoder;
    @Autowired
    private KorisnikService korisnikService;

    private KorisnikRepository korisnikRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Korisnik> korisnik = korisnikRepo.findKorisnikByKorisnickoIme(username);

        korisnik.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        //System.out.println(korisnik);

        KorisnikDetails korisnikDetails = new KorisnikDetails(korisnik.get());

        return korisnikDetails;

    }

}
