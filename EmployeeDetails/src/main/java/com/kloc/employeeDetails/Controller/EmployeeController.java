package com.kloc.employeeDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloc.employeeDetails.Entity.Department;
import com.kloc.employeeDetails.Entity.Employee;
import com.kloc.employeeDetails.Entity.EmployeeDto;
import com.kloc.employeeDetails.Service.AddressService;
import com.kloc.employeeDetails.Service.DeptService;
import com.kloc.employeeDetails.Service.EmployeeService;

@RestController
@RequestMapping("/EDT")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DeptService departmentService;
	@Autowired
	private AddressService addressService;
	
	//------------------department------------
	@PostMapping("/saveDept")
	public ResponseEntity<Department> createDepartment(@RequestBody Department dept)
	{
		return new ResponseEntity<Department>(departmentService.SaveDepartment(dept),HttpStatus.OK);
	}
	@GetMapping("/getAllDept")
	public ResponseEntity<List<Department>> findAllDepartment()
	{
		return new ResponseEntity<List<Department>>(departmentService.getAllDepartment(),HttpStatus.FOUND);
	}
	@GetMapping("/getDeptByDeptId/{deptId}")
	public ResponseEntity<Department> findDepartmentById(@PathVariable String deptId)
	{
		return new ResponseEntity<Department>(departmentService.getDeptByDeptId(deptId),HttpStatus.FOUND);
	}
	
	
	//------------------Employee-----------------
	@PostMapping("/saveEmp/{mgrId}/{deptId}")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody Employee employee,@PathVariable String mgrId,@PathVariable String deptId)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(employee, deptId, mgrId),HttpStatus.OK);
	}
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<EmployeeDto>> findAllEmployee()
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployee(),HttpStatus.FOUND);
	}
	@GetMapping("/getEmpById/{empId}")
	public ResponseEntity<EmployeeDto> findEmpByEmpId(@PathVariable String empId)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeByEmployeeId(empId),HttpStatus.FOUND);
	}
	@GetMapping("/getAllEmpByCity/{city}")
	public ResponseEntity<List<EmployeeDto>> FindAllEmpByCity(@PathVariable String city)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployeeByCity(city),HttpStatus.FOUND);
	}
	@GetMapping("/getAllEmpBydName/{dName}")
	public ResponseEntity<List<EmployeeDto>> FindAllEmpBydName(@PathVariable String dName)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployeeByDeptName(dName),HttpStatus.FOUND);
	}
	@GetMapping("/getAllEmpByMagName/{MagName}")
	public ResponseEntity<List<EmployeeDto>> FindAllEmpByMagName(@PathVariable String MagName)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployeeByManagerName(MagName),HttpStatus.FOUND);
	}
}
