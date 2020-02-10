package com.twu.biblioteca.application;

import com.twu.biblioteca.view.BibliotecaView;

import java.util.Scanner;

public class BibliotecaApp {
    private BibliotecaView bibliotecaView;

    public BibliotecaApp(BibliotecaView bibliotecaView){
        this.bibliotecaView = bibliotecaView;
    }

    public void start(){
        int menuOption = 0;

        System.out.println(bibliotecaView.showWelcomeMessage());

        do {
            bibliotecaView.showMenuOptions().forEach(option -> System.out.println(option));

            Scanner scanner = new Scanner(System.in);
             if (scanner.hasNextInt()){
                 menuOption = scanner.nextInt();
                 selectMenuOption(menuOption);
             } else {
                 System.out.println(bibliotecaView.showInvalidOption());
             }

        } while(menuOption != 0);
    }

    public void selectMenuOption(int option){
        switch (option){
            case 0: System.out.println(bibliotecaView.quitBiblioteca());
                    break;
            case 1: bibliotecaView.showAvailableBooks().forEach(book -> System.out.println(book));
                    break;
            case 2: bibliotecaView.checkoutBook();
                    break;
            case 3: bibliotecaView.returnBook();
                    break;
            case 4: bibliotecaView.showAvailableMovies().forEach(movie -> System.out.println(movie));
                    break;
            case 5: bibliotecaView.checkoutMovie();
                    break;
            case 6: bibliotecaView.returnMovie();
                    break;
            default: System.out.println(bibliotecaView.showInvalidOption());
                    break;
        }
    }
}
