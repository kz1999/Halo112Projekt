package com.example.halo112_generic.rest;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.domain.MyUserDetails;
import com.example.halo112_generic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    //@Value("${com.example.halo112_generic.admin.password}")
    //private String adminPasswordHash;

    PasswordEncoder pswdEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("OVO JE TEST\n");
        Optional<User> korisnik = userRepo.findUserByUserName(username);
        //System.out.println("OVO JE KORISNIK: " + korisnik.get().toString());
        //System.out.println("\n");

        korisnik.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        //System.out.println(korisnik);

        MyUserDetails myUserDetails = new MyUserDetails(korisnik.get());

        //System.out.println("OVO JE USERDETAILS KORISNIKA: " + myUserDetails.toString());

        return myUserDetails;

    }

}
