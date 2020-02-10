package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private List<Movie> movies = new ArrayList<Movie>();

    public MovieRepository() {
        this.movies.add(new Movie("Joker", "2019", "Todd Phillips", 5, false));
        this.movies.add(new Movie("LALALAND", "2017", "Damien Chazelle", 5, false));
    }

    public List<Movie> getAll(){
        return movies;
    }

    public Movie toggleCheckout(Movie movie){
        movie.isCheckedOut = !movie.isCheckedOut;
        return movie;
    }

}
