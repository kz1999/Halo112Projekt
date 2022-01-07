package com.example.halo112_generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
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
