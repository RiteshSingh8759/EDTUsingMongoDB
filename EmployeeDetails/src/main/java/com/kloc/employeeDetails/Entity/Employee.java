package com.kloc.employeeDetails.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Employee")
public class Employee 
{
	@Transient
	public static final String SEQUENCE_NAME="Emp_";
	@Id
	private String id;
	private String ename;
	private EmpAddress address;
	private Department dept;
	private Employee employee;
}
