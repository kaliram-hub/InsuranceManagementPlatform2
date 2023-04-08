package com.imt.care.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.care.model.Policy;
import com.imt.care.repo.PolicyRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepo policyRepo;

	@Override
	public Policy createPolicy(Policy policy) {
		return policyRepo.save(policy);
	}

	@Override
	public Policy getPolicyById(Long policyId) {
		Optional<Policy> optionalPolicy = policyRepo.findById(policyId);
		return optionalPolicy.get();
	}

	@Override
	public List<Policy> getAllPolicy() {
		return policyRepo.findAll();
	}

	@Override
	public Policy updatePolicy(Policy policy) {
		Policy existingPolicy = policyRepo.findById(policy.getPolicyId()).get();
		existingPolicy.setPolicyId(policy.getPolicyId());
		existingPolicy.setPolicyNumber(policy.getPolicyNumber());
		existingPolicy.setType(policy.getType());
		existingPolicy.setPremium(policy.getPremium());
		existingPolicy.setCoverageAmount(policy.getCoverageAmount());
		existingPolicy.setStartDate(policy.getStartDate());
		existingPolicy.setEndDate(policy.getEndDate());
		Policy updatedPolicy = policyRepo.save(existingPolicy);
		return updatedPolicy;
	}

	@Override
	public void deletePolicy(Long policyId) {
		policyRepo.deleteById(policyId);
	}

}
