package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    private BookService bookService;
    private MovieService movieService;
    private UserService userService;
    private CheckoutBookService checkoutBookService;
    private CheckoutMovieService checkoutMovieService;

    public BibliotecaView(BookService bookService, MovieService movieService, UserService userService, CheckoutBookService checkoutBookService, CheckoutMovieService checkoutMovieService){
        this.bookService = bookService;
        this.movieService = movieService;
        this.userService = userService;
        this.checkoutBookService = checkoutBookService;
        this.checkoutMovieService = checkoutMovieService;
    }

    public String showWelcomeMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangelore!";
    }

    public List<String> showMenuOptions(){
        List<String> menuOptions = new ArrayList<String>();

        menuOptions.add("Please select an option:");
        menuOptions.add("1. List of Books");
        menuOptions.add("2. Checkout a book");
        menuOptions.add("3. Return a book");
        menuOptions.add("4. List of Movies");
        menuOptions.add("5. Checkout a movie");
        menuOptions.add("6. Return a movie");
        menuOptions.add("7. Login");
        menuOptions.add("0. Quit");

        return menuOptions;
    }

    public List<String> showAvailableBooks(){
        List<String> books = new ArrayList<String>();

        bookService.getAllAvailableBooks().forEach(book -> books.add(MessageFormat
                .format("Title: {0} | Author: {1} | Publication Year: {2}", book.title, book.author, book.publicationYear)));

        return books;
    }

    public String showInvalidOption() {
        return "Please select a valid option!";
    }

    public String quitBiblioteca() {
        return "Bye bye!";
    }

    public String showSuccessCheckouBooktMessage(){
        return "Thank you! Enjoy the book.";
    }

    public String showInvalidCheckoutBookMessage(){
        return "Sorry, that book is not available.";
    }

    public void checkoutBook(){
        Book book = null;
        User user = userService.get();

        if (user == null) user = login();

        do {
            System.out.println("Please enter the valid name of the book you want to checkout");

            Scanner scanner = new Scanner(System.in);
            String bookName = scanner.nextLine();

            book = bookService.get(bookName);
            if (book == null) System.out.println(showInvalidCheckoutBookMessage());

        }while(book == null);

        checkoutBookService.checkoutBook(book, user);

        System.out.println(showSuccessCheckouBooktMessage());
    }

    public String showSuccessfulReturnMessage(){
        return "Thank you for returning the book.";
    }

    public String showInvalidBookReturnMessage(){
        return "That is not a valid book to return.";
    }

    public void returnBook(){
        Book book = null;
        User user = userService.get();

        if (user == null) user = login();

        do {
            System.out.println("Please enter the valid name of the book you want to return");

            Scanner scanner = new Scanner(System.in);
            String bookName = scanner.nextLine();

            book = bookService.get(bookName);

            if(book == null) System.out.println(showInvalidBookReturnMessage());

        }while(book == null);

        checkoutBookService.returnBook(book, user);

        System.out.println(showSuccessfulReturnMessage());
    }

    public List<String> showAvailableMovies(){
        List<String> movies = new ArrayList<String>();

        movieService.getAllAvailableMovies().forEach(movie -> movies.add(MessageFormat
                .format("Name: {0} | Year: {1} | Director: {2} | Rating: {3}", movie.name, movie.year, movie.director, movie.rating)));

        return movies;
    }

    public String showSuccessCheckoutMovieMessage(){
        return "Thank you! Enjoy the movie.";
    }

    public String showInvalidCheckoutMovieMessage(){
        return "Sorry, that movie is not available.";
    }

    public void checkoutMovie(){
        Movie movie = null;
        User user = userService.get();

        if (user == null) user = login();

        do {
            System.out.println("Please enter the valid name of the movie you want to checkout");

            Scanner scanner = new Scanner(System.in);
            String movieName = scanner.nextLine();

            movie = movieService.get(movieName);

            if (movie == null) System.out.println(showInvalidCheckoutMovieMessage());

        }while(movie == null);

        checkoutMovieService.checkoutMovie(movie, user);

        System.out.println(showSuccessCheckoutMovieMessage());
    }

    public String showSuccessfulReturnMovieMessage(){
        return "Thank you for returning the movie.";
    }

    public String showInvalidBookReturnMovieMessage(){
        return "That is not a valid movie to return.";
    }

    public void returnMovie(){
        Movie movie = null;
        User user = userService.get();

        if (user == null) user = login();

        do {
            System.out.println("Please enter the valid name of the movie you want to return");

            Scanner scanner = new Scanner(System.in);
            String movieName = scanner.nextLine();

            movie = movieService.get(movieName);

            if(movie == null) System.out.println(showInvalidBookReturnMovieMessage());
        }while(movie == null);

        checkoutMovieService.returnMovie(movie, user);

        System.out.println(showSuccessfulReturnMovieMessage());
    }

    public User login(){
        User user = null;

        do {
            System.out.println("Please enter your library number:");

            Scanner scanner = new Scanner(System.in);
            String libraryNumber = scanner.nextLine();

            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            user = userService.login(libraryNumber,password);

            if(user == null) System.out.println("Invalid login. Please try again");

        }while(user == null);

        return user;
    }
}
