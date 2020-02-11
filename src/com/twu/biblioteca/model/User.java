package com.twu.biblioteca.model;

public class User {

    public static int count = 0;

    public int id;
    public String libraryNumber;
    public String password;

    public User(String libraryNumber, String password) {
        count++;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.id = count;
    }
}
