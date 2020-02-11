package com.twu.biblioteca.service;

import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.CheckoutBookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;
    private CheckoutBookRepository checkoutBookRepository;

    public BookService(BookRepository bookRepository, CheckoutBookRepository checkoutBookRepository){
        this.bookRepository = bookRepository;
        this.checkoutBookRepository = checkoutBookRepository;
    }

    public List<Book> getAllAvailableBooks(){
        List<Book> availableBooks = new ArrayList<Book>();

        bookRepository.getAll().forEach(book -> {
            boolean isCheckedOut = checkoutBookRepository.isCheckedOut(book.id);
            if(!isCheckedOut){
                availableBooks.add(book);
            }
        });

        return availableBooks;
    }
}
