package com.twu.biblioteca.service;

import com.twu.biblioteca.repository.BookRepository;

import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @Before
    public  void setup() {
        bookRepository = new BookRepository();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldGetAllBooks() {
        assertFalse(bookService.getAll().isEmpty());
    }
}