package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Passbook;
import com.cpo.bank.repository.PassbookRepository;

@Service
public class PassbookService {

	@Autowired
	PassbookRepository passbookRepository;
	
	//All Checks
	public List<Passbook> getAllPassbooks(){
		return (List<Passbook>) passbookRepository.findAll();
	}
	
	//Specific Passbook
	public Passbook getPassbookById(int id) {
		Optional<Passbook> passbook = passbookRepository.findById(id);
		if(passbook.isPresent()) {
			return passbook.get();
		}
		else {
			return null;
		}
	}
	
	//Create Passbook
	public Passbook createPassbook(Passbook passbook) {
		return passbookRepository.save(passbook);
	}
	
	//Update Passbook
	public void updatePassbook(Passbook passbook, int loanID) {
		passbookRepository.save(passbook);
	}

	//Delete Passbook
	public void deleteById(int id) {
		passbookRepository.deleteById(id);
	}
	
}
