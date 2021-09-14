package com.cpo.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpo.bank.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
