package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<User>();

    public UserRepository() {
        this.users.add(new User("123-1234", "senha", "Stephano", "stephano@gmail.com", "999999999"));
        this.users.add(new User("010-1010", "password","Camila", "camila@gmail.com", "888888888"));
    }

    public List<User> getAll(){return users;}

    public User get(int userId){
        return this.users.stream().filter(user -> user.id == userId).findAny().orElse(null);
    }

    public User userVerify(String libraryNumber, String password){
        return users.stream()
                .filter(user -> user.libraryNumber.equals(libraryNumber) && user.password.equals(password))
                .findAny()
                .orElse(null);
    }
}
