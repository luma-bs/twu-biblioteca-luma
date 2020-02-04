package com.twu.biblioteca.service;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.model.Book;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return bookRepository.getAll();
    }

}
