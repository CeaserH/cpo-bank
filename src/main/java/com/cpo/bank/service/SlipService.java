package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Slip;
import com.cpo.bank.repository.SlipRepository;

@Service
public class SlipService {

	@Autowired
	SlipRepository slipRepository;
	
	//All Checks
	public List<Slip> getAllSlips(){
		return (List<Slip>) slipRepository.findAll();
	}
	
	//Specific Slip
	public Slip getSlipById(int id) {
		Optional<Slip> slip = slipRepository.findById(id);
		if(slip.isPresent()) {
			return slip.get();
		}
		else {
			return null;
		}
	}
	
	//Create Slip
	public Slip createSlip(Slip slip) {
		return slipRepository.save(slip);
	}
	
	//Update Slip
	public void updateSlip(Slip slip) {
		slipRepository.save(slip);
	}

	//Delete Slip
	public void deleteById(int id) {
		slipRepository.deleteById(id);
	}
	
}
