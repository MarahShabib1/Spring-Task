package com.spring.mysql.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL ,mappedBy="customer" ,orphanRemoval=true)
	List<Reservation> reservation=new ArrayList<>();
	
	public Customer() {
		
	}

	public Customer(String name, List<Reservation> reservation) {
	super();
	this.name = name;
	this.reservation = reservation;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}



	

	
	
}
