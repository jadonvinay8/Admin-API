package com.capgemini.AdminAPI.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

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

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.capgemini.AdminAPI.beans.ShortMovie;
import com.capgemini.AdminAPI.entities.Movie;
import com.capgemini.AdminAPI.entities.Screen;
import com.capgemini.AdminAPI.services.MovieService;
import com.capgemini.AdminAPI.services.TheaterService;

/**
 * Controller for handling theater related end-points
 * 
 * @author Vinay Pratap Singh
 *
 */
@RestController
@RequestMapping("/theaters")
public class TheaterController {
	
	private final TheaterService theaterService;
	
	private final MovieService movieService;

	@Autowired
	public TheaterController(TheaterService theaterService, MovieService movieService) {
		this.theaterService = theaterService;
		this.movieService = movieService;
	}

//	private DynamoDBMapper dynamoDBMapper;
//    
//	@Autowired
//	private AmazonDynamoDB amazonDynamoDB;
//
//	@PostConstruct
//	public void setup() {
//		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Screen.class);
//        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L)); 
//        amazonDynamoDB.createTable(tableRequest);
//	}
	
	@PostMapping("/{id}/screens")
	public ResponseEntity<Screen> addScreenInATheater(@PathVariable("id") String theaterId,
													  @RequestBody Screen screen) {
		return new ResponseEntity<Screen>(theaterService.addScreen(theaterId, screen), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/movies")
	public ResponseEntity<List<ShortMovie>> getMoviesInATheater(@PathVariable("id") String id) {
		return new ResponseEntity<List<ShortMovie>>(theaterService.getMovies(id), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/movies/{movieId}")
	public ResponseEntity<Movie> addMovieInATheater(@PathVariable("id") String id,
													@PathVariable("movieId") String movieId) {
		return new ResponseEntity<Movie>(movieService.attachMovieToATheater(id, movieId), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}/movies/{movieId}")
	public ResponseEntity<Movie> removeMovieFromATheater(@PathVariable("id") String theaterId,
														 @PathVariable("movieId") String movieId) {
		return new ResponseEntity<Movie>(movieService.removeMovieFromATheater(theaterId, movieId), HttpStatus.OK);
	}

}
