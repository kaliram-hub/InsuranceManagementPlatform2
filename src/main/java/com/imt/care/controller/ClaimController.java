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

import com.imt.care.model.Claim;
import com.imt.care.service.ClaimService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/claims")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	//REST API for build create Claims
		 // http://localhost:8080/api/claims
		@PostMapping
		public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
			Claim savedClaim = claimService.createClaim(claim);
			return new ResponseEntity<Claim>(savedClaim, HttpStatus.CREATED);
		}
		// build get claims by id REST API
	    // http://localhost:8080/api/claims/1
		@GetMapping("{id}")
		public ResponseEntity<Claim> getClaimById(@PathVariable("id") Long claimId) {
			Claim claim = claimService.getClaimById(claimId);
			return new ResponseEntity<Claim>(claim , HttpStatus.OK);
		}
		// Build Get All claims REST API
	    // http://localhost:8080/api/claims
		@GetMapping
		public ResponseEntity<List<Claim>> getAllClaim() {
			List<Claim> claims = claimService.getAllClaim();
			return new ResponseEntity<List<Claim>>(claims , HttpStatus.OK);
		}
		// Build Update claims REST API
		// http://localhost:8080/api/claims/1
		@PutMapping("{id}")
		public ResponseEntity<Claim> updateClaim(@PathVariable("id") Long claimId,
				@RequestBody Claim claim) {
			claim.setClaimId(claimId);
			Claim updateClaim = claimService.updateClaim(claim);
			return new ResponseEntity<Claim>(updateClaim , HttpStatus.OK);
		}
		// Building Delete claims REST API
			@DeleteMapping("{id}")
			public ResponseEntity<String> deleteClaim(@PathVariable("id") Long claimId) {
				claimService.deleteClaim(claimId);
				return new ResponseEntity<String>("Claim successfully deleted !" , HttpStatus.OK);
			}

}
