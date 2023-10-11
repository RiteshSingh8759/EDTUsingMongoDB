package com.kloc.employeeDetails.Service;

import java.util.List;

import com.kloc.employeeDetails.Entity.Department;

public interface DeptService 
{
	Department SaveDepartment(Department department);
	Department getDeptByDeptId(String deptId);
	List<Department> getAllDepartment();
}
