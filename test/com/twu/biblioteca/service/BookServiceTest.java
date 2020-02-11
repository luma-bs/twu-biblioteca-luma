package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.repository.BookRepository;

import com.twu.biblioteca.repository.CheckoutBookRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;
    private CheckoutBookRepository checkoutBookRepository;

    @Before
    public  void setup() {
        bookRepository = mock(BookRepository.class);
        checkoutBookRepository = mock(CheckoutBookRepository.class);
        bookService = new BookService(bookRepository, checkoutBookRepository);
    }

    @Test
    public void shouldGetAllAvailableBooks() {
        List<Book> allBooks = new ArrayList<Book>();
        Book checkedOutBook = new Book("Twilight", "Stephani Meyer", "2001");

        allBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rolling", "1997"));
        allBooks.add(checkedOutBook);

        when(checkoutBookRepository.isCheckedOut(2)).thenReturn(true);

        List<Book> actual = bookService.getAllAvailableBooks();

        assertFalse(actual.isEmpty());
        assertFalse(actual.contains(checkedOutBook));
    }

    @Test
    public void shouldGetBookByName(){
        Book book = new Book("Twilight", "Stephani Meyer", "2001");

        when(bookRepository.get("Twilight")).thenReturn(book);

        assertEquals(book, bookService.get("Twilight"));
    }
}