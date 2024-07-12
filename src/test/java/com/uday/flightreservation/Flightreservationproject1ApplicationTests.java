package com.uday.flightreservation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.flightreservation.entities.User;
import com.uday.flightreservation.repos.userRepository;

@SpringBootTest
class Flightreservationproject1ApplicationTests {
    @Autowired 
	private userRepository userrepo;
/*	@Test
	void contextLoads() {
		User entity = new User();
		entity.setFirstName("udayjj");
		entity.setLastName("kiranbbb");
		entity.setEmail("udaf.gmail.com");
		entity.setPassword("gh");
		userrepo.save(entity);
	}*/
	@Test
  void test() {
		
		  User user = userrepo.findById(1l).get();
		System.out.println(user);
		
	}
	
	

}
