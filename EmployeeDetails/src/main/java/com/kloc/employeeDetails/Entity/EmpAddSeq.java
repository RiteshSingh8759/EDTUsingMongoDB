package com.kloc.employeeDetails.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="EmpAddSeq")
public class EmpAddSeq 
{
	@Id
	private String id;
	private int seq;

}
