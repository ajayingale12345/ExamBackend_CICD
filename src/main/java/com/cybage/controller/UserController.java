package com.cybage.controller;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cybage.Exceptions.UserNotFoundException;
import com.cybage.entity.Role;
import com.cybage.entity.User;
import com.cybage.entity.UserRole;
import com.cybage.service.UserService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/test")
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("Default.png");
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<UserRole>();
		
		Role role = new Role();
		role.setRoleId(44);
		role.setRoleName("Engineer");
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		User user1=null;
		try {
			user1 = this.userService.createUser(user, roles);
		    
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<User>(user1, HttpStatus.OK);

	}

	@GetMapping("/getUserByName/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		System.out.println("Controller"+username);
		User user=userService.findByUserName(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id, @RequestBody User User) throws Exception {
	
		User user = userService.findUserById(id);
		if (user == null)
			throw new UserNotFoundException("User Not Found");
		else
			
		
		  return new ResponseEntity<User>(userService.updateUser(User), HttpStatus.OK);

	}

}
