package com.cpo.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpo.bank.model.Employee;
import com.cpo.bank.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//get All Accounts
	@GetMapping("/allEmployees")
	private List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	// get Employee by ID
	@GetMapping("/employee/{employeeID}")
	private Employee getemployee(@PathVariable("employeeID") int employeeID) {
		return employeeService.getEmployeeById(employeeID);
	}
	
	//add Employee
	@PostMapping("/employee")
	private Employee saveEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return employee;
	}
	
	//update Employee
	@PutMapping("/employee")
	private Employee update(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return employee;
	}
	
	//Delete Employee
	@DeleteMapping("/employee/{employeeID}")
	private void deleteEmployee(@PathVariable("employeeID") int employeeID) {
		employeeService.deleteById(employeeID);
	}
	
}
