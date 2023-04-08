package com.imt.care.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imt.care.model.Policy;

public interface PolicyRepo extends JpaRepository<Policy, Long> {

}
