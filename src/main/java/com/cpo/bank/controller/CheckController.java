package com.cpo.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpo.bank.model.Check;
import com.cpo.bank.service.CheckService;

@RestController
public class CheckController {
	
	@Autowired
	CheckService checkService;
	
	// get all checks
	@GetMapping("/allChecks")
	private List<Check> getAllChecks() {
		return checkService.getAllChecks();
	}
	
	//Get Specific Check
	@GetMapping("/check/{checkID}")
	private Check getCheck(@PathVariable("checkID") int checkID) {
		return checkService.getCheckById(checkID);
	}
	
	//add Check
	@PostMapping("/check")
	private Check addCheck(@RequestBody Check check) {
		checkService.createCheck(check);
		return check;
	}
	
	//updateCheck
	@PutMapping("/check")
	private Check update(@RequestBody Check check) {
		checkService.updateCheck(check);
		return check;
	}
	
	//delete Check
	@DeleteMapping("/check/{checkID}")
	private void deleteCheck(@PathVariable("checkID") int checkID) {
		checkService.deleteById(checkID);
	}

}
