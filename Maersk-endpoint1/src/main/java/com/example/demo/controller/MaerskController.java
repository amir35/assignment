package com.example.demo.controller;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AvailableSpace;
import com.example.demo.dto.Booking;
import com.example.demo.dto.BookingReference;
import com.example.demo.dto.CustomerQuery;
import com.example.demo.dto.SeatsAvailable;
import com.example.demo.service.MaerskService;

@RestController
@RequestMapping("/api/bookings")
public class MaerskController {
	
	@Autowired
	private MaerskService maerskService;
	
	@PostMapping("/")
	public SeatsAvailable getQuery(@Valid @RequestBody CustomerQuery customerQuery)
	{
		
		return maerskService.getQuery(customerQuery);
			
			
	}
	
	@PostMapping("/booking")
	public BookingReference doBooking(@RequestBody Booking booking)
	{
		//maerskService.doBooking(booking);
		
		booking.setTimestamp(ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_DATE_TIME ));
		
		return maerskService.doBooking(booking);
	}
	
	@GetMapping("/checkAvailable")
	public AvailableSpace checkAvailability(CustomerQuery customerQuery) {
		
		return maerskService.checkAvailability(customerQuery);
		
	}
	
}
