package com.twu.biblioteca.model;

public class CheckoutMovie {
    public static int count;

    public int id;
    public int movieId;
    public int userId;
    public boolean hasReturned;

    public CheckoutMovie(int movieId, int userId, boolean hasReturned) {
        count ++;
        this.movieId = movieId;
        this.userId = userId;
        this.hasReturned = hasReturned;
        this.id = count;
    }
}
