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

import com.cpo.bank.model.Passbook;
import com.cpo.bank.service.PassbookService;

@RestController
public class PassbookController {

	@Autowired
	PassbookService passbookService;
	
	//Passbook Update
	@GetMapping("/passbook/update")
	private void updatePassbook() {
		
	}
	
	//Account Summary
	@GetMapping("/passbook/summary")
	private void passbookSummary() {
		
	}
	
}
