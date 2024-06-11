package com.usto.re.ushort.configs.handles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;

@Priority(1)
@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> toResponse(Exception e, HttpServletRequest request){
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
