package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<Book>();

    public BookRepository(){
        this.books.add(new Book("A Court of Thorns and Roses"));
        this.books.add(new Book("Throne of Glass"));
    }

    public List<Book> getAll(){
        return books;
    }
}
