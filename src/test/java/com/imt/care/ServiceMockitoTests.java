package com.imt.care;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.imt.care.model.Client;
import com.imt.care.repo.ClientRepo;
import com.imt.care.service.ClientServiceImpl;

@SpringBootTest
public class ServiceMockitoTests {
	
	@Mock
	ClientRepo clientRepo;
	
	@InjectMocks
	ClientServiceImpl clientServiceImpl;
	
	public List<Client> allClients;
	
	@Test
	@Order(1)
	public void testGetAllClient() {
		List<Client> allClients = new ArrayList<Client>();
		when(clientRepo.findAll()).thenReturn(allClients);
		allClients.add(new Client(1, "kaliram", "21-12-1992", "banglore","8093939040"));
		allClients.add(new Client(2, "sandeep", "21-12-1993", "Hyd","8093938080"));
		when(clientRepo.findAll()).thenReturn(allClients);//Mocking
		assertEquals(2, clientServiceImpl.getAllClient().size());
	}
	
//	@Test
//	@Order(2)
//	public void testGetClientById() {
//		List<Client> allClients = new ArrayList<Client>();
//		when(clientRepo.findAll()).thenReturn(allClients);
//		allClients.add(new Client());
//		allClients.add(new Client());
//		
//		Long clientId= (long) 1;
//		when(clientRepo.findAll()).thenReturn(allClients);
//		assertEquals(clientId, clientServiceImpl.getClientById(clientId).getClientId());
//	}
}






























