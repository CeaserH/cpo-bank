package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Object save(long id);

	Object save(String name);

}
