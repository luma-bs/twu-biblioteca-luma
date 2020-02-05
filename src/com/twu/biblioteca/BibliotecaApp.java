package com.twu.biblioteca;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.view.BibliotecaView;

import java.util.Scanner;

public class BibliotecaApp {
    private BookRepository bookRepository;
    private BookService bookService;
    private BibliotecaView bibliotecaView;

    public BibliotecaApp(){
        bookRepository = new BookRepository();
        bookService = new BookService(bookRepository);
        bibliotecaView =  new BibliotecaView(bookService);
    }

    public void start(){
        int menuOption = 0;

        System.out.println(bibliotecaView.showWelcomeMessage());
        do {
            bibliotecaView.showMenuOptions().forEach(option -> System.out.println(option));

            Scanner scanner = new Scanner(System.in);
            menuOption = scanner.nextInt();

            selectMenuOption(menuOption);
        } while(menuOption != -1);
    }

    public void selectMenuOption(int option){
        switch (option){
            case 1: bibliotecaView.showBooks().forEach(book -> System.out.println(book));
                    break;
            default: System.out.println("Please select a valid option!");
                    break;
        }
    }
}
