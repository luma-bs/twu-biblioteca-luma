package com.twu.biblioteca;

import com.twu.biblioteca.application.BibliotecaApp;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private BibliotecaView bibliotecaView;

    @Before
    public void setup(){
        bibliotecaView = mock(BibliotecaView.class);
        bibliotecaApp = new BibliotecaApp(bibliotecaView);
    }

    @Test
    public void shouldCallFistMenuOption(){
        bibliotecaApp.selectMenuOption(1);

        verify(bibliotecaView, times(1)).showAvailableBooks();
    }

    @Test
    public void shouldShowInavlidOpionWhenGivenWrongNumber(){
        bibliotecaApp.selectMenuOption(-1);

        verify(bibliotecaView, times(1)).showInvalidOption();
    }

    @Test
    public void shouldQuitTheAppWhenSelected(){
        bibliotecaApp.selectMenuOption(0);

        verify(bibliotecaView, times(1)).quitBiblioteca();
    }

    @Test
    public void shouldCheckoutABookWhenSelected(){
        bibliotecaApp.selectMenuOption(2);

        verify(bibliotecaView, times(1)).checkoutBook();
    }

    @Test
    public void shouldCheckinABookWhenSelected(){
        bibliotecaApp.selectMenuOption(3);

        verify(bibliotecaView, times(1)).returnBook();;
    }

    @Test
    public void shouldShowAllMoviesAvailable(){
        bibliotecaApp.selectMenuOption(4);

        verify(bibliotecaView, times(1)).showAvailableMovies();;
    }

    @Test
    public void shouldCheckouAMovie(){
        bibliotecaApp.selectMenuOption(5);

        verify(bibliotecaView, times(1)).checkoutMovie();;
    }

    @Test
    public void shouldReturnAMovie(){
        bibliotecaApp.selectMenuOption(6);

        verify(bibliotecaView, times(1)).returnMovie();;
    }

    @Test
    public void shouldLoginAUser(){
        bibliotecaApp.selectMenuOption(7);

        verify(bibliotecaView, times(1)).login();;
    }

    @Test
    public void shouldShowUserProfile(){
        bibliotecaApp.selectMenuOption(8);

        verify(bibliotecaView, times(1)).showProfile();;
    }
}
