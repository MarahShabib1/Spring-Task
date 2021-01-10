package com.spring.mysql.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.mysql.api.model.Car;

public interface CarRepository extends CrudRepository<Car ,Integer> {
	

}
