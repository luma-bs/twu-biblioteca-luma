package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
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

    @Before
    public void setup(){
        movieRepository = mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void shouldGetAllAvailableMovies(){
        List<Movie> alLMovies = new ArrayList<Movie>();
        Movie checkedOutMovie = new Movie("LALALAND", "2017", "Damien Chazelle", 5, true);

        alLMovies.add(new Movie("Joker", "2019", "Todd Phillips", 5, false));
        alLMovies.add(checkedOutMovie);

        when(movieRepository.getAll()).thenReturn(alLMovies);

        List<Movie> actual = movieService.getAllAvailableMovies();

        assertNotNull(actual);
        assertFalse(actual.contains(checkedOutMovie));
    }

    @Test
    public void shouldCheckoutAMovie(){
        List<Movie> allMovies = new ArrayList<Movie>();
        Movie movie = new Movie("Joker", "2019", "Todd Phillips", 5, false);
        Movie expectedResult = new Movie("Joker", "2019", "Todd Phillips", 5, true);
        allMovies.add(movie);

        when(movieRepository.getAll()).thenReturn(allMovies);

        when(movieRepository.toggleCheckout(movie)).thenReturn(expectedResult);

        Movie actual = movieService.checkoutMovie("Joker");

        assertNotNull(actual);
        assertTrue(actual.isCheckedOut);
    }

    @Test
    public void shouldGetAllCheckedOutMoviess(){
        List<Movie> allMovies = new ArrayList<Movie>();
        Movie checkedinMovie = new Movie("Joker", "2019", "Todd Phillips", 5, false);

        allMovies.add(new Movie("LALALAND", "2017", "Damien Chazelle", 5, true));
        allMovies.add(checkedinMovie);

        when(movieRepository.getAll()).thenReturn(allMovies);

        List<Movie> actual = movieService.getAllMoviesCheckedOut();

        assertFalse(actual.isEmpty());
        assertFalse(actual.contains(checkedinMovie));
    }

    @Test
    public void shouldReturnAMovie(){
        List<Movie> allMovies = new ArrayList<Movie>();
        Movie movie = new Movie("Joker", "2019", "Todd Phillips", 5, true);
        Movie expectedResult = new Movie("LALALAND", "2017", "Damien Chazelle", 5, false);
        allMovies.add(movie);

        when(movieRepository.getAll()).thenReturn(allMovies);

        when(movieRepository.toggleCheckout(movie)).thenReturn(expectedResult);

        Movie actual = movieService.returnMovie("Joker");

        assertNotNull(actual);
        assertFalse(actual.isCheckedOut);
    }

    @Test
    public void shouldReturnNullWhenMovieIsNotValidToChangeCheckin(){
        List<Movie> allMovies = new ArrayList<Movie>();
        Movie returnedMovie = new Movie("Joker", "2019", "Todd Phillips", 5, false);
        allMovies.add(returnedMovie);

        when(movieRepository.getAll()).thenReturn(allMovies);

        Movie actual = movieService.returnMovie("Joker");

        assertNull(actual);
    }
}
