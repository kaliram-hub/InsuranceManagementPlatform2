package com.imt.care.model;

import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="client_id")
	private Long clientId;
	
	@Column(name="name")
	@NotEmpty(message = "Client name minimum must be atleast 4 char")
	@Size(min = 4, message = "Client name minimum must be atleast 4 char")
	private String name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="addr")
	@Size(min=6, message = "address must be 10 char")
	private String address;
	@Column(name="contact")
	private Long contact;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_client_id",referencedColumnName = "client_id")
	private List<Policy> policy;
	
	//constructor for passing Unit tests
		public Client(int i, String string, String string4, String string2, String string3) {
		}
	
	
	
	
	
	

}
