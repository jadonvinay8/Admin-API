package com.capgemini.AdminAPI.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.AdminAPI.beans.ShortMovie;
import com.capgemini.AdminAPI.beans.ShortTheater;
import com.capgemini.AdminAPI.dao.TheaterDAO;
import com.capgemini.AdminAPI.entities.City;
import com.capgemini.AdminAPI.entities.Movie;
import com.capgemini.AdminAPI.entities.Theater;
import com.capgemini.AdminAPI.exceptions.TheaterNotFoundException;

/**
 * Service class to perform CRUD operations related to Theater functionality
 * 
 * @author Vinay Pratap Singh
 *
 */
@Service
public class TheaterService {

	@Autowired
	private TheaterDAO theaterDAO;

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private MovieService movieService;
	
	private final static boolean ADD_THEATER = true;
	private final static boolean REMOVE_THEATER = false;
	

	public Theater findTheaterById(String id) {
		return theaterDAO.findById(id).orElseThrow(TheaterNotFoundException::new);
	}

	public List<ShortMovie> getMovies(String id) {
		return findTheaterById(id).getMovies();
	}

	public Theater addTheater(String cityId, Theater theater) {
		Theater savedTheater = theaterDAO.save(theater);
		updateAttachedCity(cityId, savedTheater, ADD_THEATER);
		return savedTheater;
	}

	public Theater removeTheater(String cityId, String theaterId) {
		Theater theater = findTheaterById(theaterId);
		theater.getMovies().forEach(movie -> removeTheaterFromAttachedMovieList(movie, theater));
		updateAttachedCity(cityId, theater, REMOVE_THEATER);
		theaterDAO.delete(theater);
		return theater;
	}

	private void updateAttachedCity(String cityId, Theater theater, boolean add) {
		City city = locationService.findById(cityId);
		List<ShortTheater> theaters = city.getTheaters();

		if (add) {
			theaters.add(new ShortTheater(theater.getTheatreId(), theater.getTheatreName()));
		} else {
			theaters = theaters.stream().filter(shortTheater -> !shortTheater.getId().equals(theater.getTheatreId()))
					.collect(Collectors.toList());
		}
		city.setTheaters(theaters);
		locationService.updateCity(city);
	}
	
	private void removeTheaterFromAttachedMovieList(ShortMovie shortMovie, Theater theater) {
		Movie movie = movieService.findById(shortMovie.getId());
		List<ShortTheater> theaters = movie.getTheatres();
		theaters = theaters.stream().filter(shortTheater -> !shortTheater.getId().equals(theater.getTheatreId()))
				.collect(Collectors.toList());
		movie.setTheatres(theaters);
		movieService.updateMovie(movie);
	}

	public Theater updateTheater(Theater theater) {
		findTheaterById(theater.getTheatreId()); // if this theater didn't exist previously, an exception will be thrown
		return theaterDAO.save(theater);
	}

}
