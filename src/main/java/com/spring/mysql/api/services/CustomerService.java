package com.spring.mysql.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.mysql.api.model.Car;
import com.spring.mysql.api.model.Customer;
import com.spring.mysql.api.repositories.CustomerRepository;

@Service
public class CustomerService {


	@Autowired
	private CustomerRepository customerRepository;
	
	
	public void addCustomers(List<Customer> newCustomer) {
		customerRepository.saveAll(newCustomer);
	}
	
 public List<Customer> getAllCustomers(){
		 
		 return  (List<Customer>) customerRepository.findAll();
 }
	
	
}
