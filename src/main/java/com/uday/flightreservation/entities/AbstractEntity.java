package com.uday.flightreservation.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass  //mapp to database 
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate the id 
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
