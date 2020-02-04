package com.twu.biblioteca.view;

import com.twu.biblioteca.service.BookService;

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

    public List<String> showBookList(){
        List<String> books = new ArrayList<String>();

        bookService.getAll().forEach(book -> books.add(book.title));

        return books;
    }
}
