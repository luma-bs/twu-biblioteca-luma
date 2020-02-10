package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllAvailableMovies(){
        List<Movie> availableMovies = new ArrayList<Movie>();

        movieRepository.getAll().forEach(movie -> {
            if(!movie.isCheckedOut){
                availableMovies.add(movie);
            }
        });

        return availableMovies;
    }

    public Movie checkoutMovie(String movieName){
        Movie checkedOutMovie = getAllAvailableMovies().stream()
                .filter(movie -> movie.name.equals(movieName))
                .findAny()
                .orElse(null);

        if(checkedOutMovie != null) checkedOutMovie = movieRepository.toggleCheckout(checkedOutMovie);

        return checkedOutMovie;
    }

    public List<Movie> getAllMoviesCheckedOut(){
        List<Movie> checkedOutMovies = new ArrayList<Movie>();

        movieRepository.getAll().forEach(movie -> {
            if(movie.isCheckedOut){
                checkedOutMovies.add(movie);
            }
        });

        return checkedOutMovies;
    }

    public Movie returnMovie(String movieName){
        Movie checkedOutMovie = getAllMoviesCheckedOut().stream()
                .filter(movie -> movie.name.equals(movieName))
                .findAny()
                .orElse(null);

        if(checkedOutMovie != null) checkedOutMovie = movieRepository.toggleCheckout(checkedOutMovie);

        return checkedOutMovie;
    }
}
