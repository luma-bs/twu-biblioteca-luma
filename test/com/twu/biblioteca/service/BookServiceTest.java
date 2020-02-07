package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @Before
    public  void setup() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldGetAllAvailableBooks() {
        List<Book> allBooks = new ArrayList<Book>();
        Book checkedOutBook = new Book("Twilight", "Stephani Meyer", "2001", true);

        allBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rolling", "1997", false));
        allBooks.add(checkedOutBook);

        when(bookRepository.getAll()).thenReturn(allBooks);

        List<Book> actual = bookService.getAllAvailableBooks();

        assertFalse(actual.isEmpty());
        assertFalse(actual.contains(checkedOutBook));
    }

    @Test
    public void shouldCheckoutABook(){
        List<Book> allBooks = new ArrayList<Book>();
        Book book = new Book("Twilight", "Stephani Meyer", "2001", false);
        Book expectedResult = new Book("Twilight", "Stephani Meyer", "2001", true);
        allBooks.add(book);

        when(bookRepository.getAll()).thenReturn(allBooks);

        when(bookRepository.toggleCheckout(book)).thenReturn(expectedResult);

        Book actual = bookService.checkoutBook("Twilight");

        assertNotNull(actual);
        assertTrue(actual.isCheckedOut);
    }

    @Test
    public void shouldReturnNullWhenBookIsNotValidToChangeCheckout(){
        List<Book> allBooks = new ArrayList<Book>();
        Book bookCheckedout = new Book("Twilight", "Stephani Meyer", "2001", true);
        allBooks.add(bookCheckedout);

        when(bookRepository.getAll()).thenReturn(allBooks);

        Book actual = bookService.checkoutBook("Twilight");

        assertNull(actual);
    }

    @Test
    public void shouldGetAllCheckedOutBooks(){
        List<Book> allBooks = new ArrayList<Book>();
        Book checkedinBook = new Book("Twilight", "Stephani Meyer", "2001", false);

        allBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rolling", "1997", true));
        allBooks.add(checkedinBook);

        when(bookRepository.getAll()).thenReturn(allBooks);

        List<Book> actual = bookService.getAllBooksCheckedOut();

        assertFalse(actual.isEmpty());
        assertFalse(actual.contains(checkedinBook));
    }

    @Test
    public void shouldReturnABook(){
        List<Book> allBooks = new ArrayList<Book>();
        Book book = new Book("Twilight", "Stephani Meyer", "2001", true);
        Book expectedResult = new Book("Twilight", "Stephani Meyer", "2001", false);
        allBooks.add(book);

        when(bookRepository.getAll()).thenReturn(allBooks);

        when(bookRepository.toggleCheckout(book)).thenReturn(expectedResult);

        Book actual = bookService.returnBook("Twilight");

        assertNotNull(actual);
        assertFalse(actual.isCheckedOut);
    }

    @Test
    public void shouldReturnNullWhenBookIsNotValidToChangeCheckin(){
        List<Book> allBooks = new ArrayList<Book>();
        Book returnedBook = new Book("Twilight", "Stephani Meyer", "2001", false);
        allBooks.add(returnedBook);

        when(bookRepository.getAll()).thenReturn(allBooks);

        Book actual = bookService.returnBook("Twilight");

        assertNull(actual);
    }
}