package com.kloc.employeeDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.kloc.employeeDetails.Entity.Department;
import com.kloc.employeeDetails.Entity.EmpAddress;
import com.kloc.employeeDetails.Entity.Employee;
import com.kloc.employeeDetails.Repository.AddressRepository;
import com.kloc.employeeDetails.Repository.DepartmentRepository;
import com.kloc.employeeDetails.Repository.EmployeeRepository;
import com.kloc.employeeDetails.SequenceGenerator.SequenceGenerator;

@SpringBootApplication
public class EmployeeDetailsApplication  
{
	public static void main(String[] args) 
	{
        SpringApplication.run(EmployeeDetailsApplication.class, args);
    }	
}
   
	
@Component
class DataInsertionRunner implements CommandLineRunner 
{
		
		@Autowired
		private SequenceGenerator sequenceGenerator;
		@Autowired
		private DepartmentRepository departmentRepository;
		@Autowired
		private AddressRepository addressRepository;
		@Autowired
		private EmployeeRepository employeeRepository;
		@Override
		public void run(String... args) 
		{
			if(employeeRepository.findAll().isEmpty())
			{
				Department department=new Department();
				department.setDeptId(Department.SEQUENCE_NAME+sequenceGenerator.getDeptSequenceNumber(Department.SEQUENCE_NAME));
				department.setDeptName("Director");
				Department d=departmentRepository.save(department);
				EmpAddress address=new EmpAddress();
				address.setAddressId(EmpAddress.SEQUENCE_NAME+sequenceGenerator.getAddressSequenceNumber(EmpAddress.SEQUENCE_NAME));
				address.setCity("BodhGaya");
				address.setDoorNo("HouseNo-15");
				address.setStreet("Dubhal near DPS");
				EmpAddress d1 =addressRepository.save(address);
				Employee employee=new Employee();
				employee.setId(Employee.SEQUENCE_NAME+sequenceGenerator.getEmpSequenceNumber(Employee.SEQUENCE_NAME));
				employee.setDept(d);
				employee.setEname("Ritesh Singh");
				employee.setAddress(d1);
				employeeRepository.save(employee);
			}
			
			
		}
}
	


