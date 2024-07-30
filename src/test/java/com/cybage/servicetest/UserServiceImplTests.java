//package com.cybage.servicetest;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.cybage.Exceptions.UserFoundException;
//import com.cybage.entity.User;
//import com.cybage.repository.RoleRepository;
//import com.cybage.repository.UserRepository;
//import com.cybage.serviceImpl.UserServiceImpl;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceImplTests {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private RoleRepository roleRepository;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Test
//    void testCreateUser() throws Exception {
//        // Create a sample user
//        User user = new User();
//        user.setUsername("testuser");
//
//        // Mock the behavior of UserRepository
//        when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
//        when(userRepository.save(user)).thenReturn(user);
//
//        // Call the createUser method of UserServiceImpl
//        com.cybage.entity.User savedUser = userService.createUser(user, new HashSet<>());
//
//        // Verify the user is saved
//        assertEquals(user.getUsername(), savedUser.getUsername());
//    }
//
//    @Test
//    void testCreateUser_UserFoundException() {
//        // Create a sample user
//        User user = new User();
//        user.setUsername("testuser");
//
//        // Mock the behavior of UserRepository to return an existing user
//        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
//
//        // Call the createUser method of UserServiceImpl and expect UserFoundException
//        assertThrows(UserFoundException.class, () -> userService.createUser(user, new HashSet<>()), "User already exists");
//
//    }
//
//    @Test
//    void testGetUser() {
//        // Create a sample user
//        User user = new User();
//        user.setUsername("testuser");
//
//        // Mock the behavior of UserRepository
//        when(userRepository.findByUsername("testuser")).thenReturn(user);
//
//        // Call the getUser method of UserServiceImpl
//        User fetchedUser = userService.findByUserName("testuser");
//
//        // Verify the fetched user
//        assertEquals(user.getUsername(), fetchedUser.getUsername());
//    }}

    
