package com.uday.flightreservation.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.uday.flightreservation.dtos.UpdateReservationRequest;
import com.uday.flightreservation.entities.Reservation;
import com.uday.flightreservation.repos.reservationRepository;

//retrive data from the post main use the restcontroller 
//controller is sent http respone in from of the ui or html
// by using thr restcontroller we can get the http responce in from json 
@RestController
@CrossOrigin 
//we run restcontroller on 8080 port number. when we communicate with the angular app we use the crossorgin annotation .because the angular has different port num is 4040
public class reservationRestController {
	@Autowired
	private reservationRepository reservationrepo;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(reservationRestController .class);
		
	@RequestMapping("/reservations/{id}")// reservations are many we geting the one reservation data
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id: "+id);
		Reservation findById =  reservationrepo.findById(id).get();
		//reservationrepo.findOne(id);
		return findById;
		
		
	}
	//here we createing one class "UpdateReservationRequest" in dto(data trasfor object). because we are updateing 
	//some attribute in reservation class like numberofbags,checkedIn. we create class with pratial updated attribute 
	//update the checkin and nuberofbag data 
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		LOGGER.info("Inside updateReservation" + request);
		   Reservation reservation = reservationrepo.findById(request.getId()).get();
	//	 reservation.setId(request.getId());
		   reservation.setNumberOfBags(request.getNumberOfBags());
		   reservation.setCheckedIn(request.getCheckedIn());
		   
		LOGGER.info("saving reservation"+reservation);
		
		return reservationrepo.save(reservation);
		
	}
	
	
	

}
