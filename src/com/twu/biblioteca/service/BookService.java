package com.twu.biblioteca.service;

import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.model.Movie;
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

    public Book getById(int bookId){
        return bookRepository.get(bookId);
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

    public Book getAvailableBook(String bookName){
        return getAllAvailableBooks().stream().filter(book -> book.title.equals(bookName)).findAny().orElse(null);
    }

    public List<Book> getAllCheckedOutBooks(){
        List<Book> checkedOutBooks = new ArrayList<Book>();

        bookRepository.getAll().forEach(book -> {
            boolean isCheckedOut = checkoutBookRepository.isCheckedOut(book.id);
            if(isCheckedOut){
                checkedOutBooks.add(book);
            }
        });

        return checkedOutBooks;
    }

    public Book getCheckedOutBook(String bookName){
        return getAllCheckedOutBooks().stream().filter(book -> book.title.equals(bookName)).findAny().orElse(null);
    }
}
