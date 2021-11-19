package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.UserService;
import com.example.halo112_generic.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceJpa implements UserService {

    @Autowired
    private UserRepository userRepo;

    //@Autowired
    private PasswordEncoder pswdEncoder;

    @Override
    //@Secured("ROLE_ADMIN")
    public List<User> listAll(){
        return userRepo.findAll();
    }

    private static final String KORISNICKO_FORMAT = "[]{8,30}";

    @Override
    //@Secured("ROLE_ADMIN")
    public User createUser(User user) throws Exception{
        Assert.notNull(user, "User object must be given");
        //Assert.isNull(user.getId(), "User ID must be null, not " + user.getId());
        Assert.notNull(user.getUserName(), "User must have UserName");
        String userName = user.getUserName();
        Assert.hasText(userName, "userName must be given");
        Assert.isTrue(userName.length()<=30,
                "userName must have at least 8 characters not " + userName);
        if(userRepo.countByUserName(user.getUserName())>0)
            throw new RequestDeniedException(
                    "User with userName " + user.getUserName() + " already exists"
            );
        //user.setPasswordHash(pswdEncoder.encode(user.getPasswordHash()));
        return userRepo.save(user);
    }

    @Override
    //@Secured("ROLE_ADMIN")
    public Optional<User> findByUserName(String userName) {
        return userRepo.findUserByUserName(userName);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public Optional<User> editUser(String userName, User user) {
        if(user.getName()!=null) userRepo.editNameUser(userName, user.getName());
        if(user.getSurname()!=null) userRepo.editSurnameUser(userName, user.getSurname());
        if(user.getEmail()!=null) userRepo.editUserEmail(userName, user.getEmail());
        if(user.getRole()!=null) userRepo.editUserRole(userName, user.getRole());
        if(user.getPhoto()!=null) userRepo.editUserPhoto(userName, user.getPhoto());
        if(user.getPhoneNumber()!=null) userRepo.editUserPhoneNumber(userName, user.getPhoneNumber());
        if(user.getPasswordHash()!=null) userRepo.editUserPasswordHash(userName, user.getPasswordHash());
        userRepo.editUserConfirmed(userName, user.isConfirmed());

        return userRepo.findUserByUserName(userName);
    }
}
