package com.twu.biblioteca.model;

public class Movie {
    public static int count = 0;

    private int id;
    public String name;
    public String year;
    public String director;
    public int rating;
    public boolean isCheckedOut;

    public Movie(String name, String year, String director, int rating, boolean isCheckedOut) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isCheckedOut = isCheckedOut;
        this.id = count;
    }
}
