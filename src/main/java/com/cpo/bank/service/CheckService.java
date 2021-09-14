package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Check;
import com.cpo.bank.repository.CheckRepository;

@Service
public class CheckService {
	
	@Autowired
	CheckRepository checkRepository;
	
	//All Checks
	public List<Check> getAllChecks(){
		return (List<Check>) checkRepository.findAll();
	}
	
	//Specific Check
	public Check getCheckById(int id) {
		Optional<Check> check = checkRepository.findById(id);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}
	
	//Create Check
	public Check createCheck(Check check) {
		return checkRepository.save(check);
	}
	
	//Update Check
	public void updateCheck(Check check, int checkID) {
		checkRepository.save(check);
	}

	//Delete Check
	public void deleteById(int id) {
		checkRepository.deleteById(id);
	}

}
