package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Component
public interface UserService {
    List<User> listAll();

    User createUser(User user) throws Exception;


    Optional<User> editUser(String korisnickoIme, User user) throws Exception;

    Optional<User> findByUserName(String korisnickoIme);

	boolean confirmUser(Long id);

	boolean denyUser(Long id);

	boolean changePrivilege(String privilege, Long id);

    Optional<User> findById(Long id);
}
