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
	
	//get All Accounts
	@GetMapping("/allPassbook")
	private List<Passbook> getAllPassbooks(){
		return passbookService.getAllPassbooks();
	}
	
	// get Passbook by ID
	@GetMapping("/passbook/{passbookID}")
	private Passbook getPassbook(@PathVariable("passbookID") int passbookID) {
		return passbookService.getPassbookById(passbookID);
	}
	
	//add Passbook
	@PostMapping("/passbook")
	private Passbook savePassbook(@RequestBody Passbook passbook) {
		passbookService.createPassbook(passbook);
		return passbook;
	}
	
	//update Passbook
	@PutMapping("/passbook")
	private Passbook update(@RequestBody Passbook passbook) {
		passbookService.updatePassbook(passbook);
		return passbook;
	}
	
	//Delete Passbook
	@DeleteMapping("/passbook/{passbookID}")
	private void deletePassbook(@PathVariable("passbookID") int passbookID) {
		passbookService.deleteById(passbookID);
	}
	
}
