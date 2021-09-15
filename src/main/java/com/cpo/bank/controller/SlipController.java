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

import com.cpo.bank.model.Slip;
import com.cpo.bank.service.SlipService;

@RestController
public class SlipController {

	@Autowired
	SlipService slipService;
	
	//get All Accounts
	@GetMapping("/allSlips")
	private List<Slip> getAllSlips(){
		return slipService.getAllSlips();
	}
	
	// get Slip by ID
	@GetMapping("/slip/{slipID}")
	private Slip getSlip(@PathVariable("slipID") int slipID) {
		return slipService.getSlipById(slipID);
	}
	
	//add Slip
	@PostMapping("/slip")
	private Slip saveSlip(@RequestBody Slip slip) {
		slipService.createSlip(slip);
		return slip;
	}
	
	//update Slip
	@PutMapping("/slip")
	private Slip update(@RequestBody Slip slip) {
		slipService.updateSlip(slip);
		return slip;
	}
	
	//Delete Slip
	@DeleteMapping("/slip/{slipID}")
	private void deleteSlip(@PathVariable("slipID") int slipID) {
		slipService.deleteById(slipID);
	}
}
