package com.kloc.employeeDetails.Service;

import java.util.List;

import com.kloc.employeeDetails.Entity.Employee;
import com.kloc.employeeDetails.Entity.EmployeeDto;

public interface EmployeeService 
{
	EmployeeDto saveEmployee(Employee employee,String deptId,String mgrId);
	EmployeeDto getEmployeeByEmployeeId(String empId);
	List<EmployeeDto> getAllEmployee();
	List<EmployeeDto> getAllEmployeeByDeptName(String deptName);
	List<EmployeeDto> getAllEmployeeByCity(String city);
	List<EmployeeDto> getAllEmployeeByManagerName(String ManagerName);
}
