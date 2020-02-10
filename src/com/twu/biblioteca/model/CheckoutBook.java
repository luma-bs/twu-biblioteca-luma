package com.twu.biblioteca.model;

public class CheckoutBook {
    public static int count;

    public int id;
    public int bookId;
    public int userId;
    public boolean hasReturned;

    public CheckoutBook(int bookId, int userId, boolean hasReturned) {
        count ++;
        this.bookId = bookId;
        this.userId = userId;
        this.hasReturned = hasReturned;
        this.id = count;
    }
}
