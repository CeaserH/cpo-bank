package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;
import com.cpo.bank.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
