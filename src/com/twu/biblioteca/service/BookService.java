package com.twu.biblioteca.service;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllAvailableBooks(){
        List<Book> availableBooks = new ArrayList<Book>();

        bookRepository.getAll().forEach(book -> {
            if(!book.isCheckedOut){
                availableBooks.add(book);
            }
        });

        return availableBooks;
    }

    public Book checkoutBook(String bookName){
        Book checkoutedBook = getAllAvailableBooks().stream()
                .filter(book -> book.title.equals(bookName))
                .findAny()
                .orElse(null);

        if(checkoutedBook != null) checkoutedBook = bookRepository.toggleCheckout(checkoutedBook);

        return checkoutedBook;
    }

    public List<Book> getAllBooksCheckedOut(){
        List<Book> checkedOutBooks = new ArrayList<Book>();

        bookRepository.getAll().forEach(book -> {
            if(book.isCheckedOut){
                checkedOutBooks.add(book);
            }
        });

        return checkedOutBooks;
    }

    public Book returnBook(String bookName){
        Book checkoutedBook = getAllBooksCheckedOut().stream()
                .filter(book -> book.title.equals(bookName))
                .findAny()
                .orElse(null);

        if(checkoutedBook != null) checkoutedBook = bookRepository.toggleCheckout(checkoutedBook);

        return checkoutedBook;
    }
}
