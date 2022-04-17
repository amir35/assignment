package com.example.demo.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AvailableSpace;
import com.example.demo.dto.Booking;
import com.example.demo.dto.BookingReference;
import com.example.demo.dto.CustomerQuery;
import com.example.demo.dto.SeatsAvailable;
import com.example.demo.exception.CustomerNotSavedException;
import com.example.demo.repository.MaerskRepository;

@Service
public class MaerskService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MaerskRepository maerskRepo;
	
	String external_url = "http://localhost:9090/api/bookings/checkAvailable";

	public SeatsAvailable getQuery(CustomerQuery customerQuery) {
		
		SeatsAvailable available = new SeatsAvailable();
		AvailableSpace as = new AvailableSpace();
		
		as = restTemplate.getForObject(external_url, AvailableSpace.class);
		
		if(as.getAvailableSpace() == 0)
		{
			available.setAvailable(false);
			return available;
		}
		else
		{
			available.setAvailable(true);
			return available;
		}
			
		
	}

	public BookingReference doBooking(Booking booking) {
		
		//System.out.println(booking);
		BookingReference br = new BookingReference();
		
		UUID uuid = UUID.randomUUID();
        
        booking.setId(uuid);
        System.out.println(booking);
        
        if(booking.getContainerSize() == 10 || booking.getContainerSize() == 20)
        {
        	maerskRepo.save(booking);
        }
        else
        {
        	String str = "HTTP 500 INTERNAL SERVER ERROR";
			throw new CustomerNotSavedException(str);
        }
        	
        
        
        
        br.setBookingRef(booking.getId().toString());
        
		return br;
		
		
		
		
	}

	public AvailableSpace checkAvailability(CustomerQuery customerQuery) {
		
		AvailableSpace as = new AvailableSpace();
		Random r = new Random();
		
		int rand = r.nextInt(10);		
		
		if(rand != 0 && rand > customerQuery.getQuantity())
		{
			as.setAvailableSpace(rand);
		}else
		{
			as.setAvailableSpace(0);
		}
		
		
		return as;
		
	}

}
