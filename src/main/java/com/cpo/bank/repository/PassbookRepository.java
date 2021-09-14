package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Passbook;

public interface PassbookRepository extends CrudRepository<Passbook, Integer> {

}
