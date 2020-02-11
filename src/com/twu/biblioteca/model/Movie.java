package com.twu.biblioteca.model;

public class Movie {
    public static int count = 0;

    public int id;
    public String name;
    public String year;
    public String director;
    public int rating;

    public Movie(String name, String year, String director, int rating) {
        count++;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.id = count;
    }
}
