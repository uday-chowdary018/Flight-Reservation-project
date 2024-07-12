package com.uday.kiran.flightcheckin1.integration;

import com.uday.kiran.flightcheckin1.integration.dtos.Reservation;
import com.uday.kiran.flightcheckin1.integration.dtos.UpdateReservationRequest;

public interface ReservationRestClient {
	//we create a integration layer (i.e RestFul client layer) for checkin which invoke the webservice that exposed by the flight reservation
 	public Reservation findReservation(Long id);
 	
 	public Reservation updatereservation(UpdateReservationRequest request);
 	
	
	

}
