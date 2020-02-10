package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @Before
    public void steup(){
        userRepository = new UserRepository();
    }

    @Test
    public void shouldReturnAllUsers(){
        assertFalse(userRepository.getAll().isEmpty());
    }

    @Test
    public void shouldReturnUserWhenCredentialAreValid(){
        String libraryNumber = "123-1234";
        String password = "senha";

        User user = userRepository.userVerify(libraryNumber, password);

        assertNotNull(user);
    }

    @Test
    public void shouldReturnNullWhenCredentialAreNotValid(){
        String libraryNumber = "123-1234";
        String password = "test";

        User user = userRepository.userVerify(libraryNumber, password);

        assertNull(user);
    }
}
