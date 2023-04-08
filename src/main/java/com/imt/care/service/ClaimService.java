package com.imt.care.service;

import java.util.List;
import com.imt.care.model.Claim;

public interface ClaimService {

	Claim createClaim(Claim claim);

	Claim getClaimById(Long claimId);

	List<Claim> getAllClaim();

	Claim updateClaim(Claim claim);

	void deleteClaim(Long claimId);
}
