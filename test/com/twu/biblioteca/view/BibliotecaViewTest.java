package com.twu.biblioteca.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.CheckoutBookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaViewTest {

    private BibliotecaView bibliotecaView;
    private BookService bookService;
    private MovieService movieService;
    private UserService userService;
    private CheckoutBookService checkoutBookService;

    @Before
    public  void setup() {
        bookService = mock(BookService.class);
        movieService = mock(MovieService.class);
        userService = mock(UserService.class);
        checkoutBookService = mock(CheckoutBookService.class);
        bibliotecaView = new BibliotecaView(bookService, movieService, userService, checkoutBookService);
    }

    @Test
    public void shouldShowWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangelore!";
        assertEquals(welcomeMessage, bibliotecaView.showWelcomeMessage());
    }

    @Test
    public void shouldShowBooks(){
        List<Book> allBooks = new ArrayList<Book>();
        allBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rolling", "1997"));
        allBooks.add(new Book("Twilight", "Stephani Meyer", "2001"));

        List<String> booksMessage = Arrays.asList("Title: Harry Potter and the Chamber of Secrets | Author: J. K. Rolling | Publication Year: 1997",
                "Title: Twilight | Author: Stephani Meyer | Publication Year: 2001");

        when(bookService.getAllAvailableBooks()).thenReturn(allBooks);

        assertThat(booksMessage, is(bibliotecaView.showAvailableBooks()));
    }

    @Test
    public void shouldShowInvalidOption(){
        String invalidOptionMessage = "Please select a valid option!";
        assertEquals(invalidOptionMessage, bibliotecaView.showInvalidOption());
    }

    @Test
    public void shouldQuitBiblioteca(){
        String quitMessage = "Bye bye!";
        assertEquals(quitMessage, bibliotecaView.quitBiblioteca());
    }

    @Test
    public void shouldShowSuccessCheckoutBookMessage(){
        String successCheckout = "Thank you! Enjoy the book.";
        assertEquals(successCheckout, bibliotecaView.showSuccessCheckouBooktMessage());
    }

    @Test
    public void shouldShowInvalidCheckoutBookMessage(){
        String invalidheckout = "Sorry, that book is not available.";
        assertEquals(invalidheckout, bibliotecaView.showInvalidCheckoutBookMessage());
    }

    @Test
    public void shouldShowSuccessfulReturnMessage(){
        String returnMessage = "Thank you for returning the book.";
        assertEquals(returnMessage, bibliotecaView.showSuccessfulReturnMessage());
    }

    @Test
    public void shouldShowInvalidBookReturn(){
        String invalidBookReturnMessage = "That is not a valid book to return.";
        assertEquals(invalidBookReturnMessage, bibliotecaView.showInvalidBookReturnMessage());
    }

    @Test
    public void shouldShowMovies(){
        List<Movie> alLMovies = new ArrayList<Movie>();
        alLMovies.add(new Movie("Joker", "2019", "Todd Phillips", 5, false));
        alLMovies.add(new Movie("LALALAND", "2017", "Damien Chazelle", 5,false));

        List<String> expectedResult = Arrays.asList("Name: Joker | Year: 2019 | Director: Todd Phillips | Rating: 5",
                "Name: LALALAND | Year: 2017 | Director: Damien Chazelle | Rating: 5");

        when(movieService.getAllAvailableMovies()).thenReturn(alLMovies);

        assertThat(expectedResult, is(bibliotecaView.showAvailableMovies()));
    }

    @Test
    public void shouldShowSuccessCheckoutMovieMessage(){
        String successCheckout = "Thank you! Enjoy the movie.";
        assertEquals(successCheckout, bibliotecaView.showSuccessCheckoutMovieMessage());
    }

    @Test
    public void shouldShowInvalidCheckoutMovieMessage(){
        String invalidheckout = "Sorry, that movie is not available.";
        assertEquals(invalidheckout, bibliotecaView.showInvalidCheckoutMovieMessage());
    }

    @Test
    public void shouldShowSuccessfulReturnMovieMessage(){
        String returnMessage = "Thank you for returning the movie.";
        assertEquals(returnMessage, bibliotecaView.showSuccessfulReturnMovieMessage());
    }

    @Test
    public void shouldShowInvalidMovieReturn(){
        String invalidBookReturnMessage = "That is not a valid movie to return.";
        assertEquals(invalidBookReturnMessage, bibliotecaView.showInvalidBookReturnMovieMessage());
    }
}
