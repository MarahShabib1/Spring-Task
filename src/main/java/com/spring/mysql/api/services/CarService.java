package com.spring.mysql.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mysql.api.model.Car;
import com.spring.mysql.api.model.Customer;
import com.spring.mysql.api.repositories.CarRepository;

@Service
public class CarService {
	
	 @Autowired
	 private CarRepository carRepository;
	
		
	 public List<Car> getAllCars(){
		 
		 return  (List<Car>) carRepository.findAll();
	
	 }
	 
		public void addCars(List<Car> newCar) {
			carRepository.saveAll(newCar);
		}

}
