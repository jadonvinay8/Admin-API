package com.capgemini.AdminAPI.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.AdminAPI.dao.LocationDAO;
import com.capgemini.AdminAPI.entities.City;
import com.capgemini.AdminAPI.exceptions.CityNotFoundException;

/**
 * Service class to perform CRUD operations related to Location functionality
 * 
 * @author Vinay Pratap Singh
 *
 */
@Service
public class LocationService {

	@Autowired
	private LocationDAO locationDAO;

	public List<City> getAllCities() {
		return StreamSupport.stream(locationDAO.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public City addCity(City city) {
		return locationDAO.save(city);
	}

	public City findById(String id) {
		return locationDAO.findById(id).orElseThrow(CityNotFoundException::new);
	}

	public City updateCity(City city) {
		findById(city.getId()); // if this city didn't exist previously, an exception will be thrown
		return locationDAO.save(city);
	}

	public City deleteCity(String id) {
		City city = findById(id);
		locationDAO.delete(city);
		return city;
	}

}
