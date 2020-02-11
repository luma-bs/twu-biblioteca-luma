package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.CheckoutBook;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CheckoutBookRepositoryTest {
    private CheckoutBookRepository checkoutBookRepository;

    @Before
    public void setup(){
        checkoutBookRepository = new CheckoutBookRepository();
    }

    @Test
    public void shouldGetAllBooks() {
        assertFalse(checkoutBookRepository.getAll().isEmpty());
    }

    @Test
    public void shouldChangeCheckoutStatus(){
        int bookId = 1;
        int userId = 1;
        CheckoutBook checkoutBook = new CheckoutBook(bookId,userId,false);

        checkoutBook = checkoutBookRepository.toggleCheckout(bookId,userId);

        assertTrue(checkoutBook.hasReturned);
    }

    @Test
    public void shouldVerifyBookStatusWhenABookIsCheckedOut(){
        int bookId = 1;
        int userId = 1;
        CheckoutBook checkoutBook = new CheckoutBook(bookId,userId,true);

        assertTrue(checkoutBookRepository.isCheckedOut(bookId));
    }
}
