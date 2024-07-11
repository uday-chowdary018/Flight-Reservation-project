package com.uday.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.uday.flightreservation.entities.User;
@EnableJpaRepositories
@Service
public interface userRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);// here we need not write the sql query to feach the email form db
	//spring data will write the query for us to feach email from db.beacause spring data will know the email is the one attribute in user class it generate the query

	

}
