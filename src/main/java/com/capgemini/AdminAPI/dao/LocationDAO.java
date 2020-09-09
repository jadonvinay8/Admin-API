package com.capgemini.AdminAPI.dao;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.AdminAPI.entities.City;

@Repository
@EnableScan
public interface LocationDAO extends CrudRepository<City, String> {
	
	Optional<City> findById(String id);
	
}
