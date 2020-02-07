package com.twu.biblioteca.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryTest;
import com.twu.biblioteca.service.BookService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BibliotecaViewTest {

    private BibliotecaView bibliotecaView;
    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public  void setup() {
        bookRepository = new BookRepository();
        bookService = new BookService(bookRepository);
        bibliotecaView = new BibliotecaView(bookService);
    }

    @Test
    public void shouldShowWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangelore!";
        assertEquals(welcomeMessage, bibliotecaView.showWelcomeMessage());
    }

    @Test
    public void shouldShowBooks(){
        List<String> books = Arrays.asList("Title: A Court of Thorns and Roses | Author: Sarah J. Mass | Publication Year: 2015",
                "Title: Throne of Glass | Author: Sarah J. Mass | Publication Year: 2012");
        assertThat(books, is(bibliotecaView.showBooks()));
    }

    @Test
    public void shouldShowInvalidOption(){
        String invalidOptionMessage = "Please select a valid option!";
        assertEquals(invalidOptionMessage, bibliotecaView.showInvalidOption());
    }

    @Test
    public void shouldQuitBiblioteca(){
        String quitMessage = "Bye bye!";
        assertEquals(quitMessage, bibliotecaView.quitBiblioteca());
    }

    @Test
    public void shouldShowSuccessCheckoutMessage(){
        String successCheckout = "Thank you! Enjoy the book.";
        assertEquals(successCheckout, bibliotecaView.showSuccessCheckoutMessage());
    }

    @Test
    public void shouldShowInvalidCheckoutMessage(){
        String invalidheckout = "Sorry, that book is not available.";
        assertEquals(invalidheckout, bibliotecaView.showInvalidCheckoutMessage());
    }

    @Test
    public void shouldShowSuccessfulReturnMessage(){
        String returnMessage = "Thank you for returning the book.";
        assertEquals(returnMessage, bibliotecaView.showSuccessfulReturnMessage());
    }

    @Test
    public void shouldShowInvalidBookReturn(){
        String invalidBookReturnMessage = "That is not a valid book to return.";
        assertEquals(invalidBookReturnMessage, bibliotecaView.showInvalidBookReturnMessage());
    }
}
