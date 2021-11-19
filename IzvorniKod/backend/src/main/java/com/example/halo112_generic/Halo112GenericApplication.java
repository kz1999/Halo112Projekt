package com.example.halo112_generic;

import com.example.halo112_generic.dao.UserRepository;
import com.example.halo112_generic.domain.User;
import com.example.halo112_generic.rest.UsersController;
import com.example.halo112_generic.service.UserService;
import com.example.halo112_generic.service.impl.UserServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.example.halo112_generic")
@EntityScan("com.example.halo112_generic.domain")
@EnableJpaRepositories("com.example.halo112_generic.dao")

public class Halo112GenericApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Halo112GenericApplication.class, args);
	}

}
