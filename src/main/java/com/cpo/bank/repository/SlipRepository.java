package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Slip;

public interface SlipRepository extends CrudRepository<Slip, Integer> {

}
