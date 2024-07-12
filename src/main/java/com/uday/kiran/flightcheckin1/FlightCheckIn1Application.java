package com.uday.kiran.flightcheckin1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightCheckIn1Application {
	// here we use only one web dependency. we cannot use the mysql, jpa because the flightcheckin application not directly communicate throught the database. it consume the data from flightreservation restfull webservice.

	public static void main(String[] args) {
		SpringApplication.run(FlightCheckIn1Application.class, args);
	}

}
