package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.Dispatcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DispatcherService {

    Dispatcher createDispatcher(Dispatcher dispatcher);

    List<Dispatcher> listAll();
}
