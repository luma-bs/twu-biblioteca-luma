package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.model.CheckoutMovie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckoutMovieRepositoryTest {
    private CheckoutMovieRepository checkoutMovieRepository;

    @Before
    public void setup(){
        checkoutMovieRepository = new CheckoutMovieRepository();
    }

    @Test
    public void shouldGetAllMovies() {
        assertFalse(checkoutMovieRepository.getAll().isEmpty());
    }

    @Test
    public void shouldChangeCheckoutStatus(){
        int movieId = 1;
        int userId = 1;
        CheckoutMovie checkoutMovie = new CheckoutMovie(movieId,userId,false);

        checkoutMovie = checkoutMovieRepository.toggleCheckout(movieId,userId);

        assertTrue(checkoutMovie.hasReturned);
    }

    @Test
    public void shouldVerifyMovieStatusWhenAMovieIsCheckedOut(){
        int movieId = 1;
        int userId = 1;
        CheckoutMovie checkoutMovie = new CheckoutMovie(movieId,userId,true);

        assertTrue(checkoutMovieRepository.isCheckedOut(movieId));
    }
}
