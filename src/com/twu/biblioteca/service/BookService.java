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

    public List<Book> getAll(){
        List<Book> availableBooks = new ArrayList<Book>();

        bookRepository.getAll().forEach(book -> {
            if(!book.isCheckedOut){
                availableBooks.add(book);
            }
        });

        return availableBooks;
    }

    public Book checkoutBook(String bookName){
        Book checkoutedBook = getAll().stream()
                .filter(book -> book.title.equals(bookName))
                .findAny()
                .orElse(null);

        if(checkoutedBook != null) checkoutedBook = bookRepository.toggleCheckout(checkoutedBook);

        return checkoutedBook;
    }
}
