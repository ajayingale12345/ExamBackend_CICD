package com.cybage.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.config.JwtUtils;
import com.cybage.entity.JWTRequest;
import com.cybage.entity.JWTResponse;
import com.cybage.entity.User;
import com.cybage.serviceImpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtils jwtUtils;
	private void authenticate(String username,String password) throws Exception
	{
		try {
		
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
		} catch (DisabledException e) {
			throw new Exception("User Disabled"+e.getMessage());
		}
		catch (BadCredentialsException e) {
			throw new Exception("User Disabled"+e.getMessage());
		}
	}

	@PostMapping("/generate-token")
	public ResponseEntity<?>generateToken(@RequestBody JWTRequest jwtRequest  ) throws Exception{
		
		try {
			System.out.println("Inside "+jwtRequest.getUsername());
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (UsernameNotFoundException e) {
		e.printStackTrace();
		throw new Exception("User not found");
}
		UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		System.out.println(userDetails);
		String token=this.jwtUtils.generateToken(userDetails);
	
		return ResponseEntity.ok(new JWTResponse(token));
}
	@GetMapping("/current-User")
	public User getCurrentUser(Principal principal) {
		return (User)this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
		
	}
}