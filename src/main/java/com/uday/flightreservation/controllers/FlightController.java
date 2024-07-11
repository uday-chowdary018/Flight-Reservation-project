package com.uday.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.uday.flightreservation.entities.Flight;
import com.uday.flightreservation.repos.flightRepository;


import java.util.List;

@Controller

public class FlightController {

	//Logging is the process of writeing message of within application to centerlised location,.
	//show that we know what exactly  happenging in application at runtime
	// we can implement Loggin in simple two steps
	// create LOGGER object , get the Logger class by using the LoggerFactory
	//LOGGER.setLevel(ERROR) in application properties
	//Logger.info("Inside shoeFindMethod()") . we(Logger) send the message to centralised location
	//Log levels: 1)ERROR (Exception is occured) 2)WARN(something might go wrong)3)INFO (send the info above method or nay dta)4)DEBUG,5)TRACE
	//SL4J is libary->LOG4J,LoGBACK
    @Autowired
    private flightRepository flightrepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
    
    
    
    @GetMapping("/findFlights")
    public String showFindFlights() {
    	LOGGER.info("Inside the showFindFlights()" );
        return "findFlights";
    }

    @PostMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                             // @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
                              ModelMap modelMap) {

        LOGGER.info("Inside the findFlights From: "+from+"TO: "+to);
        
     //   System.out.println("Parameters - From: " + from + ", To: " + to + ", Departure Date: " + departureDate);
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      //  System.out.println(from);
      //  System.out.println(to);
      //  System.out.println("Formatted Departure Date: " + sdf.format(departureDate));
        List<Flight> flights = flightrepo.findAllFlights(from, to 
        		//,departureDate
        		);
     LOGGER.info("Flights found are: "+flights);
     
        //System.out.println("Number of flights found: " + flights.size());
/*
        for (Flight flight : flights) {
            System.out.println(flight);
        }*/

        modelMap.addAttribute("flights", flights);

        return "displayFlights";
    }
}

/*
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uday.flightreservation.entities.Flight;
import com.uday.flightreservation.repos.flightRepository;

@Controller
public class flightController {
	
	@Autowired
	 private flightRepository flightrepos;
	@GetMapping("/findFlights")
	public String showFlights() {
		return "findFlights";
		
	}

   
    @PostMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
                              ModelMap modelMap) {

        System.out.println("Parameters - From: " + from + ", To: " + to + ", Departure Date: " + departureDate);
try {
        List<Flight> flights = flightrepos.findAllFlights(from, to, departureDate);
        System.out.println("Number of flights found: " + flights.size());

        for (Flight flight : flights) {
            System.out.println(flight);
        }

        modelMap.addAttribute("flights", flights);
}catch(Exception e) {
	e.printStackTrace();
}

        return "displayFlights";
    }
	/*
	 @PostMapping("/findFlights")
	    public String findFlights(ModelMap modelMap) {
	        String from = "CityA";
	        String to = "CityB";
	        Date departureDate = java.sql.Date.valueOf("2024-06-25"); // Using java.sql.Date

	        List<Flight> flights = flightrepos.findFlights(from, to, departureDate);
	        System.out.println("Number of flights found: " + flights.size());

	        for (Flight flight : flights) {
	            System.out.println(flight);
	        }

	        modelMap.addAttribute("flights", flights);

	        return "displayFlights";
	    }
*/
	/*
	 @PostMapping("/findFlights")
	    public String findFlights(@RequestParam("from") String from,
	                              @RequestParam("to") String to,
	                              @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
	                              ModelMap modelMap) {

	        List<Flight> flights = flightrepos.findFlights(from, to, departureDate);
	       // System.out.println(flights);
	                              System.out.println(flights.size());
	        modelMap.addAttribute("flights", flights);

	        return "displayFlights";
	    }
	


	/* @PostMapping("/findFlights")
	    public String findFlights(@RequestParam("from") String from,
	                              @RequestParam("to") String to,
	                              @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
	                              ModelMap modelMap) {

	        List<Flight> flights = flightrepos.findFlights(from, to, departureDate);
	        modelMap.addAttribute("flights", flights);

	        return "displayFlights";
	    }

	  /* @PostMapping("findFlights")
	   public String FindFlights(@RequestParam("from") String from,@RequestParam("to") String to,
			   @RequestParam("dapartureDate") @DateTimeFormat(pattern = "YYYY-MM-DD") Date departureDate , ModelMap modelMap) {
		   
		        List<Flight> flights = flightrepos.findFlights(from, to, departureDate);
		        modelMap.addAttribute("flights", flights);
		        
		        
		return "displayFlights";
		   
	   }
	   */
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	
/**
	@RequestMapping(value = "/findFlights", method = RequestMethod.GET)
	public List<Flight> flights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate")  Date departureDate,	ModelMap modelmap){
			//@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date
		// departureDate,ModelMap modelmap) {
		List<Flight> flights=null;
try {
		 flights = flightrepos.findAllFlights(from, to, departureDate);
		//System.out.println(flights);
		modelmap.addAttribute("flights", flights);
		System.out.println(flights);
		System.out.println(flights);
}
catch(Exception e) {
	e.printStackTrace();
}
return flights;	

	}
	*/


