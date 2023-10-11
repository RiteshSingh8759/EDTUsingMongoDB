package com.kloc.employeeDetails.Service.ServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloc.employeeDetails.Entity.Department;
import com.kloc.employeeDetails.Entity.EmpAddress;
import com.kloc.employeeDetails.Entity.Employee;
import com.kloc.employeeDetails.Entity.EmployeeDto;
import com.kloc.employeeDetails.Exceptions.DataNotFoundException;
import com.kloc.employeeDetails.Exceptions.InvalidInput;
import com.kloc.employeeDetails.Repository.AddressRepository;
import com.kloc.employeeDetails.Repository.DepartmentRepository;
import com.kloc.employeeDetails.Repository.EmployeeRepository;
import com.kloc.employeeDetails.SequenceGenerator.SequenceGenerator;
import com.kloc.employeeDetails.Service.AddressService;
import com.kloc.employeeDetails.Service.DeptService;
import com.kloc.employeeDetails.Service.EmployeeService;
@Service
public class EmpDeptAddServiceImpl implements EmployeeService,DeptService,AddressService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private SequenceGenerator sequenceGenerator;
	
	
	//-----------------address-----------------
	@Override
	public EmpAddress getAddressByAddressId(String addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpAddress> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//---------------Employee----------------
	
	@Override
	public EmployeeDto saveEmployee(Employee employee,String deptId,String mgrId) {
		employee.setId(Employee.SEQUENCE_NAME+sequenceGenerator.getEmpSequenceNumber(Employee.SEQUENCE_NAME));
		Employee manager=employeeRepository.findById(mgrId).orElseThrow(()->new DataNotFoundException("invalid manager id"));
		Department department=departmentRepository.findById(deptId).orElseThrow(()->new DataNotFoundException(deptId));
		if(deptId.equals(null)||mgrId.equals(null)||mgrId.isEmpty()||deptId.isEmpty())
		{
			throw new InvalidInput("invalid input");
		}
		employee.setDept(department);
		employee.setEmployee(manager);
		EmpAddress address=employee.getAddress();
		address.setAddressId(EmpAddress.SEQUENCE_NAME+sequenceGenerator.getAddressSequenceNumber(EmpAddress.SEQUENCE_NAME));
		addressRepository.save(address);
		employee.setAddress(address);
		employeeRepository.save(employee);
		EmployeeDto emp=new EmployeeDto();
		emp.setCity(employee.getAddress().getCity());
		emp.setDeptName(department.getDeptName());
		emp.setDoorNo(employee.getAddress().getDoorNo());
		emp.setEmployeeName(employee.getEname());
		emp.setManagerName(employee.getEmployee().getEname());
		emp.setStreet(employee.getAddress().getStreet());
		return emp;
	}

	@Override
	public EmployeeDto getEmployeeByEmployeeId(String empId) {
		if(empId.equals(null)||empId.isEmpty()) {throw new InvalidInput("invalid input");}
		Employee employee=employeeRepository.findById(empId).orElseThrow(()->new DataNotFoundException("data is not found with given id"));	
		EmployeeDto buildEmployee=EmployeeDto.builder().city(employee.getAddress().getCity()).deptName(employee.getDept().getDeptName()).doorNo(employee.getAddress().getDoorNo()).employeeName(employee.getEname()).managerName(employee.getEmployee().getEname()).street(employee.getAddress().getStreet()).build();
		return buildEmployee;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		return employeeRepository.findAll().stream().map(employee->{
		return EmployeeDto.builder().city(employee.getAddress().getCity())
				.deptName(employee.getDept().getDeptName())
				.doorNo(employee.getAddress().getDoorNo())
				.employeeName(employee.getEname())
				.managerName(employee.getEmployee().getEname())
				.street(employee.getAddress().getStreet())
				.build();
		}).collect(Collectors.toList());
	}
	@Override
	public List<EmployeeDto> getAllEmployeeByDeptName(String deptName) {
		 return employeeRepository.findAll().stream().filter(e->e.getDept().getDeptName().equals(deptName)).map(employee->{
			return EmployeeDto.builder().city(employee.getAddress().getCity())
					.deptName(employee.getDept().getDeptName())
					.doorNo(employee.getAddress().getDoorNo())
					.employeeName(employee.getEname())
					.managerName(employee.getEmployee().getEname())
					.street(employee.getAddress().getStreet())
					.build();
			}).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getAllEmployeeByCity(String city) {
		 return employeeRepository.findAll().stream().filter(e->e.getAddress().getCity().equals(city)).map(employee->{
				return EmployeeDto.builder().city(employee.getAddress().getCity())
						.deptName(employee.getDept().getDeptName())
						.doorNo(employee.getAddress().getDoorNo())
						.employeeName(employee.getEname())
						.managerName(employee.getEmployee().getEname())
						.street(employee.getAddress().getStreet())
						.build();
				}).collect(Collectors.toList());
	}
	@Override
	public List<EmployeeDto> getAllEmployeeByManagerName(String ManagerName) {
		return employeeRepository.findAll().stream().filter(e->!Objects.isNull(e.getEmployee())&&e.getEmployee().getEname().equals(ManagerName)).map(employee->{
			return EmployeeDto.builder().city(employee.getAddress().getCity())
					.deptName(employee.getDept().getDeptName())
					.doorNo(employee.getAddress().getDoorNo())
					.employeeName(employee.getEname())
					.managerName(employee.getEmployee().getEname())
					.street(employee.getAddress().getStreet())
					.build();
		}).collect(Collectors.toList());
	}

	//-----------Department-------------
	
	
	@Override
	public Department SaveDepartment(Department department) {
		department.setDeptId(Department.SEQUENCE_NAME+sequenceGenerator.getDeptSequenceNumber(Department.SEQUENCE_NAME));
		 return departmentRepository.save(department);
	}
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}
	
	@Override
	public Department getDeptByDeptId(String deptId) 
	{
		return departmentRepository.findById(deptId).orElseThrow(()->new DataNotFoundException("Department id is wrong"));
	}

	
	
}
