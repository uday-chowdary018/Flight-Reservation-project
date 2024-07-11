package com.uday.flightreservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;



import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;

@Component
public class emailUtil {
	@Autowired
	private JavaMailSender sender;
	 private static final Logger LOGGER = LoggerFactory.getLogger( emailUtil.class);
		
	
	public void sendItinerary(String toAddress, String filePath){
		
		LOGGER.info("Invoke the SendItinarary() and pass values are: " +toAddress+" "+filePath);
			
		MimeMessage message = sender.createMimeMessage();
		//to send through sender the data createMimemessage method is in the JavaMailSender 
				//we can diretly assig rhr address,subject,body to message .but we create the recipy and lot to code.by using MimeMessageHelper(it is a class) is so essy
				//see in location project
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinarary for your Flight");
			messageHelper.setText("Please find your Itinarary attached");
			messageHelper.addAttachment("fileName", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			//e.printStackTrace();
			LOGGER.error("Exception Inside endItinerary(): "+e);
		}
		
	}

}
