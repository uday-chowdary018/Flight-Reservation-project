package com.uday.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.flightreservation.entities.Passenger;



public interface passengerRepository extends JpaRepository<Passenger, Long> {

}
