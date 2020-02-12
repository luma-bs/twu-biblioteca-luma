package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.CheckoutBook;

import java.util.ArrayList;
import java.util.List;

public class CheckoutBookRepository {
    private List<CheckoutBook> checkoutBookList = new ArrayList<CheckoutBook>();

    public CheckoutBookRepository() {
        this.checkoutBookList.add(new CheckoutBook(1,1,false));
    }

    public List<CheckoutBook> getAll(){ return checkoutBookList; }

    public CheckoutBook addCheckout(int bookId, int userId){
        CheckoutBook checkoutBook = new CheckoutBook(bookId, userId, false);
        this.checkoutBookList.add(checkoutBook);
        return checkoutBook;
    }

    public CheckoutBook toggleCheckout(int bookId, int userId){
        CheckoutBook checkout = getAll()
                .stream()
                .filter(checkoutBook -> checkoutBook.bookId == bookId && checkoutBook.userId == userId)
                .findAny()
                .orElse(null);

        if (checkout != null) checkout.hasReturned = !checkout.hasReturned;

        return checkout;
    }

    public boolean isCheckedOut(int bookId){
        return this.checkoutBookList.stream().anyMatch(checkoutBook -> checkoutBook.bookId == bookId && !checkoutBook.hasReturned);
    }
}
