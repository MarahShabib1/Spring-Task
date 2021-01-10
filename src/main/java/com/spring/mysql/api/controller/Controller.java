package com.spring.mysql.api.controller;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.mysql.api.model.Car;
import com.spring.mysql.api.model.Customer;
import com.spring.mysql.api.model.Reservation;
import com.spring.mysql.api.repositories.CarRepository;
import com.spring.mysql.api.repositories.CustomerRepository;
import com.spring.mysql.api.repositories.ReservationRepository;
import com.spring.mysql.api.services.ReservationService;
import com.spring.mysql.api.services.CarService;
import com.spring.mysql.api.services.CustomerService;

@RestController
@RequestMapping("/CarRental")
public class Controller {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private CarService carService;
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/AllCars")
	public List<Car> getAllCars() {
		
		return carService.getAllCars();	
	}
	
	
	@PostMapping("/rent/{Customerid}/{Carid}")
	public String Reservation(@Validated @RequestBody Reservation rese,@Validated @PathVariable int Customerid,@Validated   @PathVariable int Carid) {
		
	  return reservationService.ReserveCar(rese, Customerid, Carid);	  
	}
	
	@PostMapping("/customer")
	public String addCustomer(@RequestBody List<Customer> newCustomer) {
		
		customerService.addCustomers(newCustomer);
		return "saved";
	}
	
	@PostMapping("/car")
	public String addCar(@RequestBody List<Car> newCar) {
		
		carService.addCars(newCar);
		return "Car Added Successfully";
	}
	

	@GetMapping("/getCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
}
