package com.twu.biblioteca;

import com.twu.biblioteca.application.BibliotecaApp;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.view.BibliotecaView;

public class BibliotecaMain {

    public static void main(String[] args) {
        BookRepository bookRepository  = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        BibliotecaView bibliotecaView = new BibliotecaView(bookService);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaView);

        bibliotecaApp.start();
    }
}
