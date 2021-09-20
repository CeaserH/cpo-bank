package com.cpo.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.repository.EmployeeRepository;

@Service
public class LoginService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void login(String username, String password) {
		
	}
	
}
