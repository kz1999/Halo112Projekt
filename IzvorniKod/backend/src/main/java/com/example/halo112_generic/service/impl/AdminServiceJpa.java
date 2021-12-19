package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.AdminRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Admin;
import com.example.halo112_generic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminServiceJpa implements AdminService {
    @Autowired
    private AdminRepository adminRepo;

    @Override
    public List<Admin> listAll() {
        return adminRepo.findAll();
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepo.findAdminById(id);
    }
}
