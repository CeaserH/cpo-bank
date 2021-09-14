package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Employee;
import com.cpo.bank.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//All Checks
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	//Specific Employee
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		else {
			return null;
		}
	}
	
	//Create Employee
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	//Update Employee
	public void updateEmployee(Employee emp, int employeeID) {
		employeeRepository.save(emp);
	}

	//Delete Employee
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
