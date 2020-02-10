package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MovieRepostoryTest {
    private MovieRepository movieRepostory;

    @Before
    public  void setup() {
        movieRepostory = new MovieRepository();
    }

    @Test
    public void shouldGetAllMovies(){
        assertFalse(movieRepostory.getAll().isEmpty());
    }

    @Test
    public void shouldChangeCheckoutStatus(){
        Movie movie = new Movie("Joker", "2019", "Todd Phillips", 5, true);

        movie = movieRepostory.toggleCheckout(movie);

        assertFalse(movie.isCheckedOut);
    }
}
