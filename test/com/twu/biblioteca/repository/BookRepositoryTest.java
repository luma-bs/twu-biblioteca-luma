package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    private BookRepository bookRepository;

    @Before
    public  void setup() {
        bookRepository = new BookRepository();
    }

    @Test
    public void shouldGetAllBooks() {
        assertFalse(bookRepository.getAll().isEmpty());
    }

    @Test
    public void shouldReturnBookByName(){
        String bookName = "Throne of Glass";

        assertNotNull(bookRepository.get(bookName));
    }

    @Test
    public void shouldReturnNullWhenBookNameNotFound(){
        String bookName = "Test";
        assertNull(bookRepository.get(bookName));
    }
}
