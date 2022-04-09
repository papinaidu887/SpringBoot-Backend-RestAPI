package com.medhansh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	
	// get All Employees Data
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	// to Create Employee or update employee
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		System.out.println(" create employee data is successfully ============================== " );
		return employeeRepository.save(employee);	
	}
	
	// to get Employee based on id
	  
	@GetMapping("/employee/{id}") 
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundExeption 
	{
		Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new	ResourceNotFoundExeption("Employee not exist with id :" +id));
		return ResponseEntity.ok(employee); 
	}
	
	// to delete employee based on id
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id)
	{
		Employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new	ResourceNotFoundExeption("Employee not exist with id :" +id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	

}
