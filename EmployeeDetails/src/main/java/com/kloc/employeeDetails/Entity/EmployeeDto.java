package com.kloc.employeeDetails.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto 
{
	private String employeeName;
	private String managerName;
	private String deptName;
	private String city;
	private String street;
	private String doorNo;
}
