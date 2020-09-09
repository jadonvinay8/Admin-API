package com.capgemini.AdminAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.AdminAPI.beans.ShortTheater;
import com.capgemini.AdminAPI.entities.City;
import com.capgemini.AdminAPI.entities.Theater;
import com.capgemini.AdminAPI.services.LocationService;
import com.capgemini.AdminAPI.services.TheaterService;

/**
 * Controller having End-points related to location
 * 
 * @author Vinay Pratap Singh
 *
 */
@RestController
@RequestMapping("/cities")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private TheaterService theaterService;
	
	
	@GetMapping
	public ResponseEntity<List<City>> getAllCities() {
		return new ResponseEntity<List<City>>(locationService.getAllCities(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<City> addCity(@RequestBody City city) {
		return new ResponseEntity<City>(locationService.addCity(city), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<City> updateCity(@RequestBody City city) {
		return new ResponseEntity<City>(locationService.updateCity(city), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<City> findCityById(@PathVariable("id") String id) {
		return new ResponseEntity<City>(locationService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<City> delteCity(@PathVariable("id") String id) {
		return new ResponseEntity<City>(locationService.deleteCity(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/theaters")
	public ResponseEntity<List<ShortTheater>> getTheaters(@PathVariable("id") String id) {
		return new ResponseEntity<List<ShortTheater>>(locationService.findById(id).getTheaters(), HttpStatus.OK);		
	}
	
	@PostMapping("/{id}/theaters")
	public ResponseEntity<Theater> addTheater(@PathVariable("id") String cityId, @RequestBody Theater theater) {
		return new ResponseEntity<Theater>(theaterService.addTheater(cityId, theater), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}/theaters/{theaterId}")
	public ResponseEntity<Theater> removeTheater(@PathVariable("id") String cityId, @PathVariable("theaterId") String theaterId) {
		return new ResponseEntity<Theater>(theaterService.removeTheater(cityId, theaterId), HttpStatus.OK);
	}
	
}
