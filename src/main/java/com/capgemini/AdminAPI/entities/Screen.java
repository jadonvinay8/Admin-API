package com.capgemini.AdminAPI.entities;

import java.util.Set;

import com.capgemini.AdminAPI.beans.ShortTheater;

public class Screen {
	
	private	Integer id;
	private	ShortTheater theatre;
	private	String screenName;
	private	Set<MoviePlan> showsPlaying;
	
	public Screen() {
		// Default Constructor
	}

	public Screen(ShortTheater theatre, String screenName, Set<MoviePlan> showsPlaying, Seat[][] seats) {
		super();
		this.theatre = theatre;
		this.screenName = screenName;
		this.showsPlaying = showsPlaying;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShortTheater getTheatre() {
		return theatre;
	}

	public void setTheatre(ShortTheater theatre) {
		this.theatre = theatre;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Set<MoviePlan> getShowsPlaying() {
		return showsPlaying;
	}

	public void setShowsPlaying(Set<MoviePlan> showsPlaying) {
		this.showsPlaying = showsPlaying;
	}

}
