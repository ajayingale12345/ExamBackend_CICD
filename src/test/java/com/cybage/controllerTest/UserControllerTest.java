package com.cybage.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cybage.controller.UserController;
import com.cybage.entity.User;
import com.cybage.service.UserService;
@SpringBootTest
class UserControllerTests {

    @Mock
    private UserService userService;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserController userController;

    @Test
    void testCreateUser() throws Exception {
        // Create a sample user
        User user = new User();
        user.setUsername("ajay");
        user.setPassword("12345");

        // Mock the behavior of UserService's createUser method
        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(userService.createUser(any(User.class), anySet())).thenReturn(user);

        // Call the createUser method of UserController
        ResponseEntity<?> responseEntity = userController.createUser(user);

        // Verify the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

//    @Test
//    void testGetUser() {
//        // Mock the behavior of UserService's getUser method
//        when(userService.findByUserName("ajay")).thenReturn(new User());
//
//        // Call the getUser method of UserController
//        ResponseEntity<User> user = userController.getUser("ajay");
//
//        // Verify the response
//        assertEquals("ajay", ((  ResponseEntity<User>) user).getUsername());
//    }

   
}
