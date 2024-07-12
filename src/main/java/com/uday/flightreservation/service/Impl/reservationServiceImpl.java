package com.uday.flightreservation.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uday.flightreservation.dtos.ReservationRequest;
import com.uday.flightreservation.entities.Flight;
import com.uday.flightreservation.entities.Passenger;
import com.uday.flightreservation.entities.Reservation;
import com.uday.flightreservation.repos.flightRepository;
import com.uday.flightreservation.repos.passengerRepository;
import com.uday.flightreservation.repos.reservationRepository;
import com.uday.flightreservation.service.reservationService;
import com.uday.flightreservation.util.emailUtil;
import com.uday.flightreservation.util.pdfGenerator;
@Service
public class reservationServiceImpl implements reservationService{
	@Autowired
	private flightRepository flightrepo;
	@Autowired
	private passengerRepository passengerrepo;
	@Autowired
	private reservationRepository reservationrepo;
	@Autowired
	private pdfGenerator pdfgen;
	@Autowired
	private emailUtil emailutility;
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(reservationServiceImpl.class);
	
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info(" bookFlight() geting the request: ");
		
		Flight flight = flightrepo.findById((long) request.getFlightId()).get();
		
		LOGGER.info("Fetching the flight for flightId"+flight);
		
		Passenger passenger = new Passenger();
		
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		LOGGER.info("saveing the passenger: "+passenger);
		Passenger savePassenger = passengerrepo.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("saveing the reservation: "+reservation);
		Reservation savedReservation = reservationrepo.save(reservation);
		
		
		String filePath="C:\\Users\\UDAY CHOWDARY\\Documents/reservations/reservation" + savedReservation.getId()+ ".pdf";
		LOGGER.info("Generationg the Itinerary");
		pdfgen.generateItinerary(savedReservation, filePath);
	//	String fileName= passenger.getFirstName();
		LOGGER.info("sending the mail ");
		emailutility.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation ;
	}

}
