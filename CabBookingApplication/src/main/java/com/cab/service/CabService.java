package com.cab.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.cab.exception.CabException;
import com.cab.model.Drivers;
import com.cab.model.LoginDTO;
import com.cab.model.User;

public interface CabService {

	
	public User registerUser(User user);
	
	public String LoginUser(LoginDTO login)throws LoginException;
	
	public boolean authenticateUser(String sessionKey)throws LoginException;
	
	public Drivers registerDriver(Drivers driver);
	
	public List<Drivers> getAvailableDrivers(String userSessionKey)throws CabException, LoginException;
	
	public String bookRidByDriveriD(Integer driverID, Integer x, Integer y, String UserSessionKey)throws CabException, LoginException;
	
	
}

