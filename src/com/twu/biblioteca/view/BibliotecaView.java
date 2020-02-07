package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookService;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    private BookService bookService;

    public BibliotecaView(BookService bookService){
        this.bookService = bookService;
    }

    public String showWelcomeMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangelore!";
    }

    public List<String> showMenuOptions(){
        List<String> menuOptions = new ArrayList<String>();

        menuOptions.add("Please select an option:");
        menuOptions.add("1. List of Books");
        menuOptions.add("2. Checkout a book");
        menuOptions.add("0. Quit");

        return menuOptions;
    }

    public List<String> showBooks(){
        List<String> books = new ArrayList<String>();

        bookService.getAll().forEach(book -> books.add(MessageFormat
                .format("Title: {0} | Author: {1} | Publication Year: {2}", book.title, book.author, book.publicationYear)));

        return books;
    }

    public String showInvalidOption() {
        return "Please select a valid option!";
    }

    public String quitBiblioteca() {
        return "Bye bye!";
    }

    public String showSuccessCheckoutMessage(){
        return "Thank you! Enjoy the book.";
    }

    public String showInvalidCheckoutMessage(){
        return "Sorry, that book is not available.";
    }

    public void checkoutBook(){
        Book book = null;

        do {
            System.out.println("Please enter the valid name of the book you want to checkout");

            Scanner scanner = new Scanner(System.in);
            String bookName = scanner.nextLine();

            book = bookService.checkoutBook(bookName);

            if (book == null) System.out.println(showInvalidCheckoutMessage());

        }while(book == null);

        System.out.println(showSuccessCheckoutMessage());
    }
}
