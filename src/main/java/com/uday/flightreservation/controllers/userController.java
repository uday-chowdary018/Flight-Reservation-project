package com.uday.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uday.flightreservation.entities.User;
import com.uday.flightreservation.repos.userRepository;

@Controller

public class userController {
	@Autowired
	private userRepository userrepo;

		@RequestMapping("/showreg")
	public String getRegistrationPage() {
		return "login/registerUser";
		
	}
	@RequestMapping(value="/registerUser",method=RequestMethod.POST) //take the data from the registerUser page 
	public String register(@ModelAttribute("user") User user) {  //passing user entity data //take the data from the registerUser page
		userrepo.save(user); //save data by using userRepositury class 
		return "login/login";  // after save it goes to the login page
		
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password ,ModelMap modelmap) {  //@requestParm is take the data from the url
		
		User user=userrepo.findByEmail(email); //feach the email id from the database through userRepository for comparing the email is correct are worng if email is not correct the return the login page
		if(user.getPassword().equals(password)) {
			return "/findFlights";
		}else {
			modelmap.addAttribute("msg", "Invalid username or password. please check it"); //modelmap is send message through   addattritubes to page
			
		}
		return "login/login";
		
		
		 
		
	}
	
	
	
	
	
}
