package com.twu.biblioteca.model;

public class User {

    public static int count = 0;

    public int id;
    public String libraryNumber;
    public String email;
    public String name;
    public String phoneNumber;
    public String password;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        count++;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = count;
    }
}
