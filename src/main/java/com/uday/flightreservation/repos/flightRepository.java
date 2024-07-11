package com.uday.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uday.flightreservation.entities.Flight;


import java.util.List;


@Repository
public interface flightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM flight WHERE departure_city = :departureCity AND arrival_city = :arrivalCity",nativeQuery = true)
    		// AND date_of_departure = :dateOfDeparture",
    		
    List<Flight> findAllFlights(@Param("departureCity") String from,
                                @Param("arrivalCity") String to);
                              // , @Param("dateOfDeparture") Date departureDate);

	
}

/*
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.uday.flightreservation.entities.Flight;


@EnableJpaRepositories
@Repository
public interface flightRepository extends JpaRepository<Flight, Long> {
	
//	List<Flight> findAllFlights(@Param("departureCity") String from,@Param("arrivalCity") String to,@Param("dateOfDeparture") String  i);
	//@Query(value="select * from reservation.flight where departure_city=:departureCity And arrival_city=:arrivalCity And date_of_departure=:dateOfDeparture",nativeQuery=true)
	
	
//	@Query(value="select *from Reservation.flight where departureCity=:departureCity and  arrivalCity=: arrivalCity and dateOfDeparture=:dateOfDeparture",nativeQuery = true)
	
//	List<Flight> findFlights(@Param("departurCity") String from,@Param("arrivalCity") String to,@Param("dateOfDeparture")  Date departureDate);
	/*  @Query(value = "select *from flight where departure_city =:departureCity and arrival_city =:arrivalCity and date_of_departure =:dateOfDeparture", nativeQuery = true)
	    List<Flight> findFlights(@Param("departureCity") String from,
	                             @Param("arrivalCity") String to,
	                             @Param("dateOfDeparture") Date departureDate);\*/
	// @Query(value = "SELECT * FROM flight WHERE departure_city = :departureCity AND arrival_city = :arrivalCity AND date_of_departure = :dateOfDeparture", nativeQuery = true)
	//    List<Flight> findAllFlights(@Param("departureCity") String from,
	       //                      @Param("arrivalCity") String to,
	         //                    @Param("dateOfDeparture") Date departureDate);
	
//}

