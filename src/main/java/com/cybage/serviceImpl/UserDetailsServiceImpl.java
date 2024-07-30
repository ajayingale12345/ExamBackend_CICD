package com.cybage.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cybage.entity.User;
import com.cybage.repository.UserRepository;
@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	@Autowired
  private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   //username="Virat18";
		User user =this.userRepository.findByUsername(username);
	      System.out.println("Ajayaaa");
		  System.out.println(user);
		   if(user==null) {
			   System.out.println("User not found");
			   throw new UsernameNotFoundException("No User Found");
		   }
		return user;
	}

}
