package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Check;

public interface CheckRepository extends CrudRepository<Check, Integer> {

}
