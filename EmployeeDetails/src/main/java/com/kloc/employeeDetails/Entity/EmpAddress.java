package com.kloc.employeeDetails.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="EmpAddress")
public class EmpAddress 
{
	@Transient
	public static final String SEQUENCE_NAME="Add_";
	@Id
	private String addressId;
	private String city;
	private String street;
	private String doorNo;
	
}
