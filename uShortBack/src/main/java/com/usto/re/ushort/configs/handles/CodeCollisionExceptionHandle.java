package com.usto.re.ushort.configs.handles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usto.re.ushort.exceptions.CodeCollisionException;

import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;

@Priority(0)
@ControllerAdvice
public class CodeCollisionExceptionHandle {
	
	@ExceptionHandler(CodeCollisionException.class)
	public ResponseEntity<?> toResponse(Exception e, HttpServletRequest request){
		return new ResponseEntity<>("Um erro inesperado ocorreu, tente novamente mais tarde.",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
