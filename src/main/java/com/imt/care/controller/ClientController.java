package com.imt.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imt.care.model.Client;
import com.imt.care.service.ClientService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	//REST API for build create Client
		// http://localhost:8080/api/clients
	@PostMapping
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
		Client savedClient = clientService.createClient(client);
		return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
	}
	// build get client by id REST API
    // http://localhost:8080/api/clients/1
	@GetMapping("{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Long clientId) {
		Client client = clientService.getClientById(clientId);
		return new ResponseEntity<Client>(client , HttpStatus.OK);
	}
	// Build Get All Users REST API
    // http://localhost:8080/api/clients
	@GetMapping
	public ResponseEntity<List<Client>> getAllClient() {
		List<Client> clients = clientService.getAllClient();
		return new ResponseEntity<List<Client>>(clients , HttpStatus.OK);
	}
	// Build Update Client REST API
	// http://localhost:8080/api/clients/1
	@PutMapping("{id}")
	public ResponseEntity<Client> updateClient(@Valid @PathVariable("id") Long clientId ,
			     										@RequestBody Client client) {
		client.setClientId(clientId);
		Client updateClient = clientService.updateClient(client);
		return new ResponseEntity<Client>(updateClient , HttpStatus.OK);
	}
	// Build Delete client REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId) {
		clientService.deleteClient(clientId);
		return new ResponseEntity<String>("Client successfully deleted !" , HttpStatus.OK);
	}
}
