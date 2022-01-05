package com.example.halo112_generic.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.Dispatcher;
import com.example.halo112_generic.domain.Dispatcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DispatcherService {

    Dispatcher createDispatcher(Dispatcher dispatcher);

    List<Dispatcher> listAll();
}
