package com.twu.biblioteca;

import com.twu.biblioteca.application.BibliotecaApp;
import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.CheckoutBookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.view.BibliotecaView;

public class BibliotecaMain {

    public static void main(String[] args) {
        BookRepository bookRepository  = new BookRepository();
        CheckoutBookRepository checkoutBook = new CheckoutBookRepository();
        BookService bookService = new BookService(bookRepository, checkoutBook);
        MovieRepository movieRepository = new MovieRepository();
        MovieService movieService = new MovieService(movieRepository);
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        BibliotecaView bibliotecaView = new BibliotecaView(bookService, movieService, userService);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaView);

        bibliotecaApp.start();
    }
}
