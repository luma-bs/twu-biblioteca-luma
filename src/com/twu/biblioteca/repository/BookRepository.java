package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<Book>();

    public BookRepository(){
        this.books.add(new Book("A Court of Thorns and Roses", "Sarah J. Mass", "2015"));
        this.books.add(new Book("Throne of Glass", "Sarah J. Mass","2012"));
    }

    public List<Book> getAll(){
        return books;
    }
}
