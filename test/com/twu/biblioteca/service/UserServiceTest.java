package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;

    @Before
    public void setup(){
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void shouldLoginWhenCredentialsAreValid(){
        String libraryNumber = "123-1234";
        String password = "password";

        User user = new User(libraryNumber, password);

        when(userRepository.userVerify(libraryNumber,password)).thenReturn(user);

        assertNotNull(userService.login(libraryNumber,password));
    }

    @Test
    public void shouldReturnTrueWhenUserIsLogged(){
        String libraryNumber = "123-1234";
        String password = "password";
        User user = new User(libraryNumber, password);

        when(userRepository.userVerify(libraryNumber,password)).thenReturn(user);
        userService.login(libraryNumber,password);

        assertTrue(userService.isLogged());
    }

    @Test
    public void shouldReturnFalseWhenUserIsLogged(){
        assertFalse(userService.isLogged());
    }
}
