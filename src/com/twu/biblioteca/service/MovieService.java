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

    public Movie getById(int movieId){
        return movieRepository.get(movieId);
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

    public Movie getAvailableMovie(String movieName){
        return getAllAvailableMovies().stream().filter(movie -> movie.name.equals(movieName)).findAny().orElse(null);
    }
    public List<Movie> getAllCheckedOutMovies(){
        List<Movie> checkedOutMovies = new ArrayList<Movie>();

        movieRepository.getAll().forEach(movie -> {
            boolean isCheckedOut = checkoutMovieRepository.isCheckedOut(movie.id);
            if(isCheckedOut){
                checkedOutMovies.add(movie);
            }
        });

        return checkedOutMovies;
    }

    public Movie getCheckedOutMovie(String movieName){
        return getAllCheckedOutMovies().stream().filter(movie -> movie.name.equals(movieName)).findAny().orElse(null);
    }
}
