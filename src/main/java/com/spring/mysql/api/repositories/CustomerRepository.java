package com.spring.mysql.api.repositories;

import org.springframework.data.repository.CrudRepository;


import com.spring.mysql.api.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer ,Integer>{

	
}
