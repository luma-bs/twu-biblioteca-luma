package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

}
