package com.capgemini.AdminAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.AdminAPI.dao.ScreenDAO;
import com.capgemini.AdminAPI.entities.Screen;
import com.capgemini.AdminAPI.exceptions.ScreenNotFoundException;

@Service
public class ScreenService {

	private final ScreenDAO screenDao;

	@Autowired
	public ScreenService(ScreenDAO screenDao) {
		this.screenDao = screenDao;
	}

	public Screen findById(String id) {
		return screenDao.findById(id).orElseThrow(ScreenNotFoundException::new); 
	}
	
	public Screen addScreen(Screen screen) {
		return screenDao.save(screen);
	}
	
}
