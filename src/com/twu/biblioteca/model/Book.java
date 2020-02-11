package com.twu.biblioteca.model;

public class Book {
    public static int count = 0;

    public int id;
    public String title;
    public String author;
    public String publicationYear;

    public Book (String title, String author, String publicationYear)
    {
        count++;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.id = count;
    }

}
