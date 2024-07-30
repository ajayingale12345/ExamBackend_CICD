package com.cybage.service;

import java.util.Set;






import com.cybage.entity.User;
import com.cybage.entity.UserRole;

public interface UserService {
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	public User findByUserName(String Username) ;
	public User findUserById(int id);
	public User updateUser(User user);
	
}
