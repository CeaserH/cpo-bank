package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
