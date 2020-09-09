package com.capgemini.AdminAPI.entities;

import com.capgemini.AdminAPI.beans.SeatState;
import com.capgemini.AdminAPI.beans.SeatType;

public class Seat {
	
	private Integer id;
	private	double price;
	private	SeatType seatType;
	private	SeatState seatState;
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Seat(double price, SeatType seatType, SeatState seatState) {
		super();
		this.price = price;
		this.seatType = seatType;
		this.seatState = seatState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public SeatState getSeatState() {
		return seatState;
	}

	public void setSeatState(SeatState seatState) {
		this.seatState = seatState;
	}
	
	
}
