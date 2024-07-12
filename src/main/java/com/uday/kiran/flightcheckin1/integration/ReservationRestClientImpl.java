package com.uday.kiran.flightcheckin1.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.uday.kiran.flightcheckin1.integration.dtos.Reservation;
import com.uday.kiran.flightcheckin1.integration.dtos.UpdateReservationRequest;





@Component
public class ReservationRestClientImpl implements ReservationRestClient{

	
	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";
     private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestClientImpl.class);
	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();	
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	//here in above method we are feachib=nf the reservation entity data by using reservation id from the url
	// when we invoke the url. url points to webservices of the flight reservation

	@Override
	public Reservation updatereservation(UpdateReservationRequest request) {
		
		/*RestTemplate restTemplate = new RestTemplate();
		
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL , request, Reservation.class);
		return reservation;
		*/
		 RestTemplate restTemplate = new RestTemplate();
	        String url = RESERVATION_REST_URL + request.getId();
	        LOGGER.info("Calling updatereservation with URL: {} and request: {}", url, request);
	        try {
	         //   restTemplate.put(url, request);
	            Reservation updatedReservation = restTemplate.postForObject(url, request, Reservation.class);
	            LOGGER.info("Updated reservation: {}", updatedReservation);
	            return updatedReservation;
	        } catch (HttpClientErrorException e) {
	            LOGGER.error("Error updating reservation: {}", e.getMessage());
	            throw e;
	        }
	}

	// we post the update reservation data into the flightreservation 
	//it invoke reservationRestController class and save the update reservation data
}
