package com.spring.mysql.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.spring.mysql.api.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation ,Integer> {
	
 public List<Reservation> findBycarId(int id);
  
         
}
