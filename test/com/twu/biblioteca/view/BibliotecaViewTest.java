package com.twu.biblioteca.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.service.BookService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BibliotecaViewTest {

    private BibliotecaView bibliotecaView;

    @Before
    public  void setup() {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
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
    public void shouldShowMenu(){
        List<String> menuOptions = Arrays.asList("Please select an option:", "1. List of Books");
        assertThat(menuOptions, is(bibliotecaView.showMenuOptions()));
    }
}
