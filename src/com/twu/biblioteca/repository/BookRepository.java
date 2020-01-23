package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.List;

public class BookRepository {

    private List<Book> books;

    public BookRepository(){
        this.books.add(new Book("A Court of Thorns and Roses"));
    }
}
