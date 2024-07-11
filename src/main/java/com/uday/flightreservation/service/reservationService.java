package com.uday.flightreservation.service;

import org.springframework.stereotype.Service;

import com.uday.flightreservation.dtos.ReservationRequest;
import com.uday.flightreservation.entities.Reservation;
@Service
public interface reservationService {
	
	
		Reservation bookFlight(ReservationRequest request);

}
