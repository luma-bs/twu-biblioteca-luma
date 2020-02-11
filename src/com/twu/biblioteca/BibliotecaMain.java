package com.twu.biblioteca;

import com.twu.biblioteca.application.BibliotecaApp;
import com.twu.biblioteca.repository.*;
import com.twu.biblioteca.service.*;
import com.twu.biblioteca.view.BibliotecaView;

public class BibliotecaMain {

    public static void main(String[] args) {
        BookRepository bookRepository  = new BookRepository();
        CheckoutBookRepository checkoutBookRepository = new CheckoutBookRepository();
        CheckoutBookService checkoutBookService = new CheckoutBookService(checkoutBookRepository);
        BookService bookService = new BookService(bookRepository, checkoutBookRepository);
        MovieRepository movieRepository = new MovieRepository();
        CheckoutMovieRepository checkoutMovieRepository = new CheckoutMovieRepository();
        CheckoutMovieService checkoutMovieService = new CheckoutMovieService(checkoutMovieRepository);
        MovieService movieService = new MovieService(movieRepository, checkoutMovieRepository);
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        BibliotecaView bibliotecaView = new BibliotecaView(bookService, movieService, userService, checkoutBookService, checkoutMovieService);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaView);

        bibliotecaApp.start();
    }
}
