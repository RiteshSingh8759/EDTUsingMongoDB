package com.kloc.employeeDetails.Service;

import java.util.List;

import com.kloc.employeeDetails.Entity.EmpAddress;

public interface AddressService 
{
	EmpAddress getAddressByAddressId(String addressId);
	List<EmpAddress> getAllAddress();
}
