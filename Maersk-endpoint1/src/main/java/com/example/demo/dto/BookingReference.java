package com.example.demo.dto;

import java.util.UUID;

public class BookingReference {
	
	private String bookingRef;

	public BookingReference(String bookingRef) {
		
		this.bookingRef = bookingRef;
	}

	public BookingReference() {
		
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}
	
	

}
