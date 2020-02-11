package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.CheckoutMovieRepository;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private MovieRepository movieRepository;
    private CheckoutMovieRepository checkoutMovieRepository;

    public MovieService(MovieRepository movieRepository, CheckoutMovieRepository checkoutMovieRepository) {
        this.movieRepository = movieRepository;
        this.checkoutMovieRepository = checkoutMovieRepository;
    }

    public List<Movie> getAllAvailableMovies(){
        List<Movie> availableMovies = new ArrayList<Movie>();

        movieRepository.getAll().forEach(movie -> {
            boolean isCheckedOut = checkoutMovieRepository.isCheckedOut(movie.id);
            if(!isCheckedOut){
                availableMovies.add(movie);
            }
        });

        return availableMovies;
    }

    public Movie get(String movieName){
        return movieRepository.get(movieName);
    }
}
