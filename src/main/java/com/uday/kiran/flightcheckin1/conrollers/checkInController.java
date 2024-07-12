package com.uday.kiran.flightcheckin1.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.uday.kiran.flightcheckin1.integration.ReservationRestClient;
import com.uday.kiran.flightcheckin1.integration.dtos.Reservation;
import com.uday.kiran.flightcheckin1.integration.dtos.UpdateReservationRequest;


//@RestController
@Controller
//@RequestMapping("/flightcheckin")
public class checkInController {
	@Autowired
	private ReservationRestClient reservationclient;
	
	
	@RequestMapping("/showStartCheckin")
     public String showStartCheckin() {
		 return "startCheckIn"; 
    }
	

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("id") Long reservationId, ModelMap modelmap) {
		
		    Reservation reservation = reservationclient.findReservation(reservationId);
		    
		    modelmap.addAttribute("reservation", reservation);
		    
		
		return "displayReservationDetails";
		
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId, 
			@RequestParam("numberOfBags") int numberOfbags, ModelMap modelmap) {
		UpdateReservationRequest reservationRequest = new UpdateReservationRequest();
		//create new object and set update value to it and pass the objectname throught method(updatereservation)
		reservationRequest.setId(reservationId);
		reservationRequest.setCheckedIn(true);
		reservationRequest.setNumberOfBags(numberOfbags);
		        reservationclient.updatereservation(reservationRequest);
		                
		   
		       String msg= "Check In Completed Successfully";
		       modelmap.addAttribute("msg", msg);
		return "checkInConfirmation";
		
	}
	
	


}
