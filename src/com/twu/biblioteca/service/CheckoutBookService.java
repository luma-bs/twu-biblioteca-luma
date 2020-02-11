package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.CheckoutBookRepository;

public class CheckoutBookService {
    private CheckoutBookRepository checkoutBookRepository;

    public CheckoutBookService(CheckoutBookRepository checkoutBookRepository) {
        this.checkoutBookRepository = checkoutBookRepository;
    }

    public CheckoutBook checkoutBook(Book book, User user){
        if (checkoutBookRepository.isCheckedOut(book.id)) return null;
        return checkoutBookRepository.addCheckout(book.id, user.id);
    }
}
