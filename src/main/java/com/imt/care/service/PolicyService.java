package com.imt.care.service;

import java.util.List;

import com.imt.care.model.Policy;

public interface PolicyService {
	
	Policy createPolicy(Policy policy);
	
	Policy getPolicyById(Long policyId);
	
	List<Policy> getAllPolicy();
	
	Policy updatePolicy(Policy policy);
	
	void deletePolicy(Long policyId);

}
