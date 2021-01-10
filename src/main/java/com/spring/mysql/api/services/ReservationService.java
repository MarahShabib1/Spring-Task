package com.spring.mysql.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.mysql.api.model.Car;
import com.spring.mysql.api.model.Customer;
import com.spring.mysql.api.model.Reservation;
import com.spring.mysql.api.repositories.CarRepository;
import com.spring.mysql.api.repositories.CustomerRepository;
import com.spring.mysql.api.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private CustomerRepository customer;
	@Autowired
	private CarRepository car;
	@Autowired
	private ReservationRepository reservation;
	
	public String ReserveCar(Reservation newReservation, int Customerid, int Carid) {
		
		Customer cusomer_exist= customer.findById(Customerid).get();
		if(cusomer_exist==null) {
			return "Customer id is not exist";
		}
		Car car_exist= car.findById(Carid).get();
		if(car_exist==null) {
			return "Car id is not exist";
		}
	
		
        List<Reservation> activeReservations=reservation.findBycarId(Carid);
        for(int i=0 ; i<activeReservations.size();i++) {
        	if(activeReservations.get(i).startdate.compareTo(newReservation.startdate) * newReservation.startdate.compareTo(activeReservations.get(i).endtdate) >0 ) {
        		if(activeReservations.get(i).startdate.compareTo(newReservation.endtdate) * newReservation.endtdate.compareTo(activeReservations.get(i).endtdate) >0 ) {
        			
        			return "Not Available";
        		}  	
        	}	
        }
        
    	newReservation.setCustomer(cusomer_exist);
		newReservation.setCar(car_exist);
		reservation.save(newReservation);
        
		return "Booked successfully" ;
		
	}
	
	
}
