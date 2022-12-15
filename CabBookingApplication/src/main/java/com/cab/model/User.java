package com.cab.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;
	
	@Pattern(regexp = "^[A-Z][a-z]*")
	@NotNull(message = "firstname name can not be null")
	private String firstName;
	
	@Pattern(regexp = "^[A-Z][a-z]*")
	@NotNull(message = "firstname name can not be null")
	private String lastName;
	
	@Size(min = 10, max = 10)
	private String mobileNo;
	
	@Size(min = 6 , max = 12)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$")
	private String password;
	
	private Integer[] currentPosition = new Integer[2];
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Drivers driver;

	
	
	
}
