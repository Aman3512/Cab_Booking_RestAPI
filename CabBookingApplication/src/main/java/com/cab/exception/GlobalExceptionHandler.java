package com.cab.exception;

import java.time.LocalDate;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CabException.class)
	public ResponseEntity<ErrorDetails> cabExceptionHandler(CabException e, WebRequest wr){
		
		ErrorDetails error = new ErrorDetails(e.getMessage(), wr.getDescription(false),LocalDate.now());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException e, WebRequest wr){
		
		ErrorDetails error = new ErrorDetails(e.getMessage(), wr.getDescription(false),LocalDate.now());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
		
		ErrorDetails error = new ErrorDetails("Validation Exception", e.getBindingResult().getFieldError().getDefaultMessage() ,LocalDate.now());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e, WebRequest wr){
		
		ErrorDetails error = new ErrorDetails(e.getMessage(), wr.getDescription(false),LocalDate.now());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
	}
	
}
