package com.imt.care.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insurance_policy")
@Entity
public class Policy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="policy_id")
	private Long policyId;
	
	private Long policyNumber;
	
	private String type;
	
	private Long coverageAmount;
	
	private String premium;
	
	private Date startDate;
	
	private Date endDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_claim_id")
	private Claim claim;
	


}
