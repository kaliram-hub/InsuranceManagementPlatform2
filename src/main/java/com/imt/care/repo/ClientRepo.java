package com.imt.care.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imt.care.model.Client;

public interface ClientRepo extends JpaRepository<Client,Long>{

}
