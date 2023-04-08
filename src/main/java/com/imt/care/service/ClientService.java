package com.imt.care.service;

import java.util.List;

import com.imt.care.model.Client;

public interface ClientService {
	
	Client createClient(Client client);
	
	Client getClientById(Long clientId);
	
	List<Client> getAllClient();
	
	Client updateClient(Client client);
	
	void deleteClient(Long clientId);

}
