package com.pe.petelosz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;


@RestController
@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ex.printStackTrace();
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

		
	@ExceptionHandler(CustomMessageException.class)
	public final ResponseEntity<Object> handleCustomMessageException(CustomMessageException cme, WebRequest request) {
		cme.printStackTrace();
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), cme.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, cme.getHttpStatus());
	}
	



}

