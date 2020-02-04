package com.twu.biblioteca;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.view.BibliotecaView;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        BibliotecaView bibliotecaView =  new BibliotecaView(bookService);

        System.out.println(bibliotecaView.showWelcomeMessage());

        bibliotecaView.showBookList().forEach(book -> System.out.println(book));
    }
}
