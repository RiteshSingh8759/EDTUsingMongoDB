package com.kloc.employeeDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kloc.employeeDetails.Entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> 
{
	
}
