package com.capgemini.AdminAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.AdminAPI.beans.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<ErrorResponse> cityNotFound(CityNotFoundException e) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("No City was found with given id", "404"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TheaterNotFoundException.class)
	public ResponseEntity<ErrorResponse> theaterNotFound(TheaterNotFoundException e) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("No theater was found with given id", "404"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ErrorResponse> movieNotFound(MovieNotFoundException e) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("No movie was found with given id", "404"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ScreenNotFoundException.class)
	public ResponseEntity<ErrorResponse> screenNotFound(ScreenNotFoundException e) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("No Screen was found with given id", "404"), HttpStatus.NOT_FOUND);
	}
	
}