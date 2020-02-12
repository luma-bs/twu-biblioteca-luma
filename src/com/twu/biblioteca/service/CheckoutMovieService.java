package com.twu.biblioteca.service;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.repository.CheckoutMovieRepository;

import java.util.List;

public class CheckoutMovieService {
    private CheckoutMovieRepository checkoutMovieRepository;

    public CheckoutMovieService(CheckoutMovieRepository checkoutMovieRepository) {
        this.checkoutMovieRepository = checkoutMovieRepository;
    }

    public List<CheckoutMovie> getAll(){
        return checkoutMovieRepository.getAll();
    }

    public CheckoutMovie checkoutMovie(Movie movie, User user){
        if (checkoutMovieRepository.isCheckedOut(movie.id)) return null;
        return checkoutMovieRepository.addCheckout(movie.id, user.id);
    }

    public CheckoutMovie returnMovie(Movie movie, User user){
        return checkoutMovieRepository.toggleCheckout(movie.id,user.id);
    }
}
