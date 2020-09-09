package com.capgemini.AdminAPI.entities;

import java.time.Instant;

import com.capgemini.AdminAPI.beans.ShortMovie;

public class MoviePlan {
	
	private	Integer id;
	private	Instant startTime;
	private	Instant endTime;
	private	ShortMovie movie;
	private	String movieDimension; // 2d 3d
	private	Seat[][] seats;
	
	public MoviePlan() {
		// Default Constructor
	}

	public MoviePlan(Instant startTime, Instant endTime, ShortMovie movie, String movieDimension, Seat[][] seats) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.movie = movie;
		this.movieDimension = movieDimension;
		this.seats = seats;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public ShortMovie getMovie() {
		return movie;
	}

	public void setMovie(ShortMovie movie) {
		this.movie = movie;
	}

	public String getMovieDimension() {
		return movieDimension;
	}

	public void setMovieDimension(String movieDimension) {
		this.movieDimension = movieDimension;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}	
	
}
