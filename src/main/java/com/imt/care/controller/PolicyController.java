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

import com.imt.care.model.Policy;
import com.imt.care.service.PolicyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/policies")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	//REST API for build create Client
			// http://localhost:8080/api/policies
	@PostMapping
	public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
		Policy savedPolicy = policyService.createPolicy(policy);
		return new ResponseEntity<>(savedPolicy, HttpStatus.CREATED);
	}
	// build get policy by id REST API
    // http://localhost:8080/api/policies
	@GetMapping("{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable("id") Long policyId) {
		Policy policy = policyService.getPolicyById(policyId);
		return new ResponseEntity<Policy>(policy , HttpStatus.OK);
	}
	// Build Get All policies REST API
    // http://localhost:8080/api/policies
	@GetMapping
	public ResponseEntity<List<Policy>> getAllPolicy() {
		List<Policy> policies = policyService.getAllPolicy();
		return new ResponseEntity<List<Policy>>(policies, HttpStatus.OK);
	}
	// Build Update policy REST API
		// http://localhost:8080/api/policies/1
		@PutMapping("{id}")
		public ResponseEntity<Policy> updatePolicy(@PathVariable("id") Long policyId,
														@RequestBody Policy policy ) {
			policy.setPolicyId(policyId);
			Policy updatePolicy = policyService.updatePolicy(policy);
			return new ResponseEntity<Policy>(updatePolicy,HttpStatus.OK);
			
		}
		// Build Delete policy REST API
		@DeleteMapping("{id}")
		public ResponseEntity<String> deletePolicy(@PathVariable("id") Long policyId){
			policyService.deletePolicy(policyId);
			return new ResponseEntity<String>("Policy successfully deleted !" , HttpStatus.OK);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
