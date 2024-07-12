package com.uday.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.flightreservation.entities.Reservation;



public interface reservationRepository extends JpaRepository<Reservation, Long> {

}
