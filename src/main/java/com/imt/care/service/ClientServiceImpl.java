package com.imt.care.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.care.exception.EmptyInputException;
import com.imt.care.model.Client;
import com.imt.care.repo.ClientRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepo clientRepo;

	@Override
	public Client createClient(Client client) {
		if(client.getName().isEmpty() || client.getName().length() == 0 ) {
			throw new EmptyInputException("601","input fields are empty");
		}
			Client savedClient = clientRepo.save(client);
		return savedClient;
	}

	@Override
	public Client getClientById(Long clientId) {
		Optional<Client> optionalClient = clientRepo.findById(clientId);
		return optionalClient.get();
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

	@Override
	public Client updateClient(Client client) {
		Client existingClient = clientRepo.findById(client.getClientId()).get();
		existingClient.setName(client.getName());
		existingClient.setClientId(client.getClientId());
		existingClient.setDob(client.getDob());
		existingClient.setAddress(client.getAddress());
		existingClient.setContact(client.getContact());
		Client updatedClient = clientRepo.save(existingClient);
		return updatedClient;
	}

	@Override
	public void deleteClient(Long clientId) {
		clientRepo.deleteById(clientId);
	}

}


















