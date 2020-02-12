package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;
    private User user;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.user = null;
    }

    public User login(String libraryNumber, String password){
        this.user =  userRepository.userVerify(libraryNumber,password);
        return user;
    }

    public User get(){
        return this.user;
    }

    public User getById(int userId){
        return userRepository.get(userId);
    }
}
