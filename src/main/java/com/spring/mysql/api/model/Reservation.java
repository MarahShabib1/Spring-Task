package com.spring.mysql.api.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reservations")
public class Reservation {
	
	@Id
	@GeneratedValue
	public int record;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate startdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate endtdate;
	public String starttime;
	public String endtime;

	@ManyToOne
//	@JoinColumn(name="car_fid")
	public Car car;
	
	@ManyToOne
	//@JoinColumn(name="customer_fid")
	public Customer customer;

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEndtdate() {
		return endtdate;
	}

	public void setEndtdate(LocalDate endtdate) {
		this.endtdate = endtdate;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	



	

	
	
	
	
	
	
	
	
	

}
