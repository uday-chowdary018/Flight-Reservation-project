package com.uday.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.uday.flightreservation.dtos.ReservationRequest;
import com.uday.flightreservation.entities.Flight;
import com.uday.flightreservation.entities.Reservation;
import com.uday.flightreservation.repos.flightRepository;
import com.uday.flightreservation.service.reservationService;
@Controller

public class reservatioinController {
	
	
	@Autowired
	private flightRepository flightrepo;
	@Autowired
	private reservationService reservationservice;
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(reservatioinController .class);
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelmap) {
		
		LOGGER.info("inside method showCompleteReservation() flightId is: "+flightId);
		Flight flight = flightrepo.findById(flightId).get();
		//System.out.println(flight.getOperatingAirlines());
		
		
		
		modelmap.addAttribute("flight", flight);
		
		
		
		return "completeReservation";
		
	}
	
	
	@PostMapping("/completeReservation")
	public String completereservation( ReservationRequest request,ModelMap modelmap) {
		LOGGER.info("Invoke the completereservation() get the request: "+request);
		Reservation reservation = reservationservice.bookFlight(request);
		
		modelmap.addAttribute("msg",
				"Reservation created successfully  and the reservation id is: "
				+reservation.getId());

        //System.out.println("Received Flight ID: " + request.getFlightId());
		
		return "reservationConfirmation";
		
	}
	
	
	
	
	
	

}
