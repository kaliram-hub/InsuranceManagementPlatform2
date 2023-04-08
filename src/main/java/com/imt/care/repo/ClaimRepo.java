package com.imt.care.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imt.care.model.Claim;

public interface ClaimRepo extends JpaRepository<Claim, Long> {

}
