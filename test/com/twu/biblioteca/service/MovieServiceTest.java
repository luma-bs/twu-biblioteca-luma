package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.CheckoutMovie;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.CheckoutMovieRepository;
import com.twu.biblioteca.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieServiceTest {
    private MovieService movieService;
    private MovieRepository movieRepository;
    private CheckoutMovieRepository checkoutMovieRepository;

    @Before
    public void setup(){
        movieRepository = mock(MovieRepository.class);
        checkoutMovieRepository = mock(CheckoutMovieRepository.class);
        movieService = new MovieService(movieRepository,checkoutMovieRepository);
    }

    @Test
    public void shouldGetAllAvailableMovies(){
        List<Movie> alLMovies = new ArrayList<Movie>();
        Movie checkedOutMovie = new Movie("LALALAND", "2017", "Damien Chazelle", 5);

        alLMovies.add(new Movie("Joker", "2019", "Todd Phillips", 5));
        alLMovies.add(checkedOutMovie);

        when(movieRepository.getAll()).thenReturn(alLMovies);

        List<Movie> actual = movieService.getAllAvailableMovies();

        assertNotNull(actual);
        assertFalse(actual.contains(checkedOutMovie));
    }
}
