package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.CheckoutBookRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CheckoutBookServiceTest {
    private CheckoutBookService checkoutBookService;
    private CheckoutBookRepository checkoutBookRepository;

    @Before
    public void setup(){
        checkoutBookRepository = mock(CheckoutBookRepository.class);
        checkoutBookService = new CheckoutBookService(checkoutBookRepository);
    }

    @Test
    public void shouldCheckoutBook(){
        Book book = new Book("Test","Dev", "2020");
        User user = new User("123-1234", "password","Stephano", "stephano@gmail.com", "999999999");
        CheckoutBook checkoutBook = new CheckoutBook(1,1,false);

        when(checkoutBookRepository.addCheckout(1,1)).thenReturn(checkoutBook);

        CheckoutBook actual = checkoutBookService.checkoutBook(book, user);

        assertEquals(checkoutBook, actual);
    }

    @Test
    public void shouldReturnBook(){
        Book book = new Book("Test","Dev", "2020");
        User user = new User("123-1234", "password","Stephano", "stephano@gmail.com", "999999999");
        CheckoutBook checkoutBook = new CheckoutBook(1,1,true);

        when(checkoutBookRepository.toggleCheckout(1,1)).thenReturn(checkoutBook);

        CheckoutBook actual = checkoutBookService.returnBook(book, user);

        assertTrue(actual.hasReturned);
    }
}
