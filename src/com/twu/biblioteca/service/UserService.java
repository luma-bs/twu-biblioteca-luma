package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String libraryNumber, String password){
        return userRepository.userVerify(libraryNumber,password);
    }
}
