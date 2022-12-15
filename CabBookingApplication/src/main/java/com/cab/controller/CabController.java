package com.cab.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.exception.CabException;
import com.cab.model.Drivers;
import com.cab.model.LoginDTO;
import com.cab.model.User;
import com.cab.service.CabService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/masaicab")
public class CabController {

	@Autowired
	private CabService service;
	
	
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUserHandler(@javax.validation.Valid @RequestBody User user){
		
		return new ResponseEntity<User>(service.registerUser(user),HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/user/login")
	public ResponseEntity<String> LoginUserHandler(@RequestBody LoginDTO login) throws LoginException{
		
		return new ResponseEntity<String>(service.LoginUser(login),HttpStatus.OK);
	}
	
	
	@PostMapping("driver/register")
	public ResponseEntity<Drivers> registerDriver(@javax.validation.Valid  @RequestBody Drivers driver){
		
		return new ResponseEntity<Drivers>(service.registerDriver(driver),HttpStatus.CREATED);
	}
	
	
	@GetMapping("user/findride")
	public ResponseEntity<List<Drivers>> getAvailableDrivers(@RequestParam String userSessionKey) throws LoginException, CabException{
		
		return new ResponseEntity<List<Drivers>>(service.getAvailableDrivers(userSessionKey),HttpStatus.OK);
	}
	
	
	@PutMapping("/user/book/{driverId}/{x}/{y}")
	public ResponseEntity<String> bookRidByDriveriD(@PathVariable Integer driverId,@PathVariable Integer x,@PathVariable Integer y,@RequestParam String UserSessionKey) throws LoginException, CabException{
		
		return new ResponseEntity<String>(service.bookRidByDriveriD(driverId, x, y, UserSessionKey),HttpStatus.OK);
	}
	
	
}
