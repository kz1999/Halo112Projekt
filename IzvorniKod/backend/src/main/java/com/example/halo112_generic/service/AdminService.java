package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface AdminService {
    List<Admin> listAll();

    Admin createAdmin(Admin admin);

    Optional<Admin> findById(Long id);

}
