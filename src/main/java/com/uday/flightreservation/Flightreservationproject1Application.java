package com.uday.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories(basePackages ="com.uday.flightreservation.repos")
public class Flightreservationproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Flightreservationproject1Application.class, args);
	}

}
