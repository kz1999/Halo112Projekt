package com.example.halo112_generic.service.impl;

<<<<<<< HEAD
import java.util.List;

=======
import com.example.halo112_generic.domain.Dispatcher;
>>>>>>> e4f9c149c1377bc790f08f04443a298b2f169e67
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.dao.DispatcherRepository;
import com.example.halo112_generic.domain.Dispatcher;
import com.example.halo112_generic.service.DispatcherService;

import java.util.List;

@Component
public class DispatcherServiceJpa implements DispatcherService{

	@Autowired
    private DispatcherRepository dispatcherRepo;
<<<<<<< HEAD
	
	@Override
	public Dispatcher createDispatcher(Dispatcher dispatcher) {
		return dispatcherRepo.save(dispatcher);
	}

	@Override
	public List<Dispatcher> listAll() {
		return dispatcherRepo.findAll();
	}
=======


    @Override
    public Dispatcher createDispatcher(Dispatcher dispatcher) {
        return dispatcherRepo.save(dispatcher);
    }

    @Override
    public List<Dispatcher> listAll() {
        return dispatcherRepo.findAll();
    }
>>>>>>> e4f9c149c1377bc790f08f04443a298b2f169e67
}
