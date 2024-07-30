package com.cybage.serviceImpl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.Exceptions.UserFoundException;
import com.cybage.Exceptions.UserNotFoundException;
import com.cybage.entity.User;
import com.cybage.entity.UserRole;
import com.cybage.repository.RoleRepository;
import com.cybage.repository.UserRepository;
import com.cybage.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			throw new UserFoundException("User is Already Present");
		} else {
			for (UserRole userRole : userRoles) {
				this.roleRepository.save(userRole.getRole());

			}
			user.getUserRoles().addAll(userRoles);
			
			if(user.getUsername()!=null) {
				local = this.userRepository.save(user);

				return local;
			}
			else {
				throw new  Exception();
			}
		}

	}

	@Override
	public User findByUserName(String Username) {
		System.out.println("UserService Impl"+Username);
   User user=userRepository.findByUsername(Username);
 
		return user ;
	}

	@Override
	public User findUserById(int id) {

		User user = userRepository.findById(id).orElse(null);
		System.out.println("Thisn is user" + user);
		return user;
	}
	@Override
	public User updateUser(User user) {
		System.out.println(user);
		User local=userRepository.save(user);
		return local;
	}

}
