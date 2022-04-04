package com.medhansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medhansh.exception.ResourceNotFoundExeption;
import com.medhansh.model.Employee;
import com.medhansh.repository.EmployeeRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class EmployeeController {
	
	int count=0;
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	// to create Employee Rest API
	@PostMapping("/addEmployee")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		System.out.println(" create employee data is successfully ============================== " );
		return employeeRepository.save(employee);
	}
	
	
	// get employee by Id rest api....
	  
	@GetMapping("/employees/{id}") 
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundExeption 
	{
		Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new	ResourceNotFoundExeption("Employee not exist with id :" +id));
		return ResponseEntity.ok(employee); 
	}
	
	// update employee rest api
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employeeBean)
	{
		Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new	ResourceNotFoundExeption("Employee not exist with id :" +id));
		
		employee.setFirstName(employeeBean.getFirstName());
		employee.setLastName(employeeBean.getLastName());
		employee.setEmailId(employeeBean.getEmailId());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	
	
	 
	
	

}
