package com.capgemini.AdminAPI.dao;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.AdminAPI.entities.Screen;

@Repository
@EnableScan
public interface ScreenDAO extends CrudRepository<Screen, String>{

	Optional<Screen> findById(String id);
	
}
