package com.capgemini.AdminAPI.entities;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.AdminAPI.beans.Address;
import com.capgemini.AdminAPI.beans.CardDetails;
import com.capgemini.AdminAPI.beans.Role;

public class User {
	
	private	Integer userId;
	private	String firstName;
	private	String lastName;
	private	LocalDate dob;
	private	String phone;
	private	String email;
	private	String password;
	private	String imgPath;
	private	List<Booking> bookings;
	private	List<Address> favoritePlaces;
	private	List<CardDetails> savedCards;
	private	Role role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, LocalDate dob, String phone, String email, String password,
			String imgPath, List<Booking> bookings, List<Address> favoritePlaces, List<CardDetails> savedCards,
			Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.imgPath = imgPath;
		this.bookings = bookings;
		this.favoritePlaces = favoritePlaces;
		this.savedCards = savedCards;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Address> getFavoritePlaces() {
		return favoritePlaces;
	}

	public void setFavoritePlaces(List<Address> favoritePlaces) {
		this.favoritePlaces = favoritePlaces;
	}

	public List<CardDetails> getSavedCards() {
		return savedCards;
	}

	public void setSavedCards(List<CardDetails> savedCards) {
		this.savedCards = savedCards;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}


