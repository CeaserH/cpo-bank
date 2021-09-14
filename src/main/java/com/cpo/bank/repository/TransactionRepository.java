package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
