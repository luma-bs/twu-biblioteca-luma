package com.twu.biblioteca.service;

import com.twu.biblioteca.model.CheckoutMovie;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.CheckoutMovieRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutMovieServiceTest {
    private CheckoutMovieService checkoutMovieService;
    private CheckoutMovieRepository checkoutMovieRepository;

    @Before
    public void setup(){
        checkoutMovieRepository = mock(CheckoutMovieRepository.class);
        checkoutMovieService = new CheckoutMovieService(checkoutMovieRepository);
    }

    @Test
    public void shouldCheckoutMovie(){
        Movie movie = new Movie("Joker", "2019", "Todd Phillips", 5);
        User user = new User("123-1234", "senha","Stephano", "stephano@gmail.com", "999999999");

        CheckoutMovie checkoutMovie = new CheckoutMovie(1,1,false);

        when(checkoutMovieRepository.addCheckout(1,1)).thenReturn(checkoutMovie);

        CheckoutMovie actual = checkoutMovieService.checkoutMovie(movie, user);

        assertEquals(checkoutMovie, actual);
    }

    @Test
    public void shouldReturnMovie(){
        Movie movie = new Movie("Joker", "2019", "Todd Phillips", 5);
        User user = new User("123-1234", "password","Stephano", "stephano@gmail.com", "999999999");
        CheckoutMovie checkoutMovie = new CheckoutMovie(1,1,true);

        when(checkoutMovieRepository.toggleCheckout(1,1)).thenReturn(checkoutMovie);

        CheckoutMovie actual = checkoutMovieService.returnMovie(movie, user);

        assertTrue(actual.hasReturned);
    }
}
