package com.pooii.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class ProyectoPooiiApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPooiiApiApplication.class, args);
	}

}
