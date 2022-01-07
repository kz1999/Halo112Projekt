package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Admin;
import com.example.halo112_generic.domain.Dispatcher;
import com.example.halo112_generic.domain.Fireman;
import com.example.halo112_generic.domain.Paramedic;
import com.example.halo112_generic.domain.Police;
import com.example.halo112_generic.domain.Responder;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.service.UserService;
import com.example.halo112_generic.service.AdminService;
import com.example.halo112_generic.service.DispatcherService;
import com.example.halo112_generic.service.FiremanService;
import com.example.halo112_generic.service.ParamedicService;
import com.example.halo112_generic.service.PoliceService;
import com.example.halo112_generic.service.RequestDeniedException;
import com.example.halo112_generic.service.ResponderService;

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

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ResponderService responderService;
    
    @Autowired
    private DispatcherService dispatcherService;
    
    @Autowired
    private PoliceService policeService;
    
    @Autowired
    private FiremanService firemanService;
    
    @Autowired
    private ParamedicService paramedService;
    
    //@Autowired
    //private PasswordEncoder pswdEncoder;

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
        user = userRepo.save(user);

        Responder r = (Responder)user;
        switch (user.getRole().toLowerCase()) {
        case "dispatcher":
        	Dispatcher d = new Dispatcher();
        	d.setUser(user);
        	dispatcherService.createDispatcher(d);
        	break;
        case "policeman":
        	r = responderService.createResponder(r);
        	Police p = new Police();
        	p.setResponder(r);
        	policeService.createPolice(p);
        	break;
        case "fireman":
        	r = responderService.createResponder(r);
        	Fireman f = new Fireman();
        	f.setResponder(r);
        	firemanService.createFireman(f);
        	break;
        case "doctor":
        	r = responderService.createResponder(r);
        	Paramedic pm = new Paramedic();
        	pm.setResponder(r);
        	paramedService.createParamed(pm);
        	break;
        case "admin":
        	Admin a = new Admin();
        	a.setUser(user);
        	adminService.createAdmin(a);
        	break;
        default:
        	System.out.println("Error: unsupported role");
        }
        
        return user;
    }

    @Override
    //@Secured("ROLE_ADMIN")
    public Optional<User> findByUserName(String userName) {
        return userRepo.findUserByUserName(userName);
    }

    @Override
    //@Secured("ROLE_ADMIN")
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
    
    @Override
	public boolean confirmUser(Long id) {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.setConfirmed(true);
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean denyUser(Long id) {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean changePrivilege(String privilege, Long id) {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.setRole(privilege);
			userRepo.save(user);
			return true;
		}
		return false;
	}
}
