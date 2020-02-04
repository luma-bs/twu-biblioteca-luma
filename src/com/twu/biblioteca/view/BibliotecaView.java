package com.twu.biblioteca.view;

import com.twu.biblioteca.service.BookService;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

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
        menuOptions.add("2. Exit");

        return menuOptions;
    }

    public List<String> showBooks(){
        List<String> books = new ArrayList<String>();

        bookService.getAll().forEach(book -> books.add(MessageFormat
                .format("Title: {0} | Author: {1} | Publication Year: {2}", book.title, book.author, book.publicationYear)));

        return books;
    }
}
