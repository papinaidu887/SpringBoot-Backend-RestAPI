package com.medhansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		System.out.println("shdkjfsahdfasfsghf ");
		count++;
		System.out.println("=====================fgsf=======sdfsd===gf " +count);

		System.out.println("----------------------------------------------------the controller......");
		
		return employeeRepository.findAll();
	}
	
	// to create Employee data...
	@PostMapping("/addEmployee")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		System.out.println(" create employee data is successfully ============================== " );
		return employeeRepository.save(employee);
	}
	
	/*
	 * // get employee by Id rest api....
	 * 
	 * @GetMapping("/employees/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable Long id) throws ResourceNotFoundExeption {
	 * Employee employee = employeeRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundExeption("Employee not exist with id :" +id));; return
	 * ResponseEntity.ok(employee); }
	 */
	
	

}
