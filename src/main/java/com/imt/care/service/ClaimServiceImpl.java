package com.imt.care.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.care.model.Claim;
import com.imt.care.repo.ClaimRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	private ClaimRepo claimRepo;
	
	@Override
	public Claim createClaim(Claim claim) {
		return claimRepo.save(claim);
	}

	@Override
	public Claim getClaimById(Long claimId) {
		Optional<Claim> optionalClaim = claimRepo.findById(claimId);
		return optionalClaim.get();
	}

	@Override
	public List<Claim> getAllClaim() {
		return claimRepo.findAll();
	}

	@Override
	public Claim updateClaim(Claim claim) {
		Claim existingClaim = claimRepo.findById(claim.getClaimId()).get();
		existingClaim.setClaimDate(claim.getClaimDate());
		existingClaim.setClaimNumber(claim.getClaimNumber());
		existingClaim.setClaimStatus(claim.getClaimStatus());
		existingClaim.setDescription(claim.getDescription());
		existingClaim.setClaimId(claim.getClaimId());
		Claim updateClaim = claimRepo.save(existingClaim);
		return updateClaim;
	}

	@Override
	public void deleteClaim(Long claimId) {
		claimRepo.deleteById(claimId);		
	}

}
