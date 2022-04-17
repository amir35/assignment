package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.dto.Booking;
import com.example.demo.dto.ContainerType;
import com.example.demo.dto.CustomerQuery;
import com.example.demo.repository.MaerskRepository;
import com.example.demo.service.MaerskService;

@SpringBootTest
@AutoConfigureMockMvc
class MaerskEndpoint1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	MaerskService maerskService;
	
	@Mock
	MaerskRepository maerskRepo;

	@Before(value = "")
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		
	}
	
	@Test
	  public void checkAvailable()throws Exception { 
		  
		  CustomerQuery c1 = new CustomerQuery(10,ContainerType.DRY,"Southampton","Singapore",5); 
		  
		  RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:9090/api/bookings/checkAvailable").
				  accept(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  
		  System.out.println(result.getResponse().getContentAsString());
		  
		  String s1 = result.getResponse().getContentAsString();
		  
		  String expected = "{availableSpace:[0-9]}";
		  
		  JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		  
		  

	  
	  }
	 
	
	@Test
	public void doBookingTest()
	{
		
		String dateTime = ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_DATE_TIME );
		
		Booking c1 = new Booking(UUID.randomUUID(),10,ContainerType.DRY,"Southampton","Singapore",5, dateTime);

		maerskRepo.save(c1);

		verify(maerskRepo, times(1)).save(c1);
		
	}
	
	
	
}
