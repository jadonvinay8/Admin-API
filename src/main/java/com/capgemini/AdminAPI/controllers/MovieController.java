package com.capgemini.AdminAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.AdminAPI.entities.Movie;
import com.capgemini.AdminAPI.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> findMovie(@PathVariable("id") String id) {
		return new ResponseEntity<Movie>(movieService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable("id") String id) {
		return new ResponseEntity<Movie>(movieService.deleteMovie(id), HttpStatus.OK);
	}
	
}
