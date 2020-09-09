package com.capgemini.AdminAPI.entities;


import java.util.Map;

public class Booking {
	String bookingId;
	User user;
	String screenName;
	String movieName;
	Map<Seat,Integer> bookedSeats;
	Transaction transaction;
//	double price;
//	int numTickets;
	String showTiming;
}
