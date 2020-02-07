package com.twu.biblioteca.model;

public class Book {
    public static int count = 0;

    private int id;
    public String title;
    public String author;
    public String publicationYear;
    public boolean isCheckedOut;

    public Book (String title, String author, String publicationYear, boolean isCheckedOut)
    {
        count++;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isCheckedOut = isCheckedOut;
        this.id = count;
    }

}
