package com.kloc.employeeDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kloc.employeeDetails.Entity.Department;

public interface DepartmentRepository extends MongoRepository<Department,String>
{

}
