package com.kloc.employeeDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kloc.employeeDetails.Entity.EmpAddress;

public interface AddressRepository extends MongoRepository<EmpAddress, String>
{

}
