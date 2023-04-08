package com.imt.care.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claim")
@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="claim_id")
	private Long claimId;
	
	private Long claimNumber;
	
	private String description;
	
	private Date claimDate;
	
	private String claimStatus;
	
//	@OneToOne(mappedBy = "claim")
//	private Policy policy;
}
