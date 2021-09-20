package com.cpo.bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpo.bank.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	private void employeeLogin(@RequestBody Map<String, Object> request) {
		
		/*
			REQUEST FORMAT
			{
				Username
				Password
			}
		 */
		
		String username = (String) request.get("Username");
		String password = (String) request.get("Password");
		
		loginService.login(username, password);
			
	}

}
