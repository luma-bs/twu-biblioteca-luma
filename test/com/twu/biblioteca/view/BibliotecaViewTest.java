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
    public void shouldShowBookList(){
        List<String> books = Arrays.asList("A Court of Thorns and Roses", "Throne of Glass");
        assertThat(books, is(bibliotecaView.showBookList()));
    }
}
