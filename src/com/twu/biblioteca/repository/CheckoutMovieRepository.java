package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.CheckoutBook;
import com.twu.biblioteca.model.CheckoutMovie;

import java.util.ArrayList;
import java.util.List;

public class CheckoutMovieRepository {
    private List<CheckoutMovie> checkoutMovieList = new ArrayList<CheckoutMovie>();

    public CheckoutMovieRepository() {
        this.checkoutMovieList.add(new CheckoutMovie(1,1,false));
    }

    public List<CheckoutMovie> getAll(){
        return this.checkoutMovieList;
    }

    public CheckoutMovie addCheckout(int movieId, int userId){
        CheckoutMovie checkoutMovie = new CheckoutMovie(movieId, userId, false);
        this.checkoutMovieList.add(checkoutMovie);
        return checkoutMovie;
    }

    public CheckoutMovie toggleCheckout(int movieId, int userId){
        CheckoutMovie checkout = getAll()
                .stream()
                .filter(checkoutMovie -> checkoutMovie.movieId == movieId && checkoutMovie.userId == userId)
                .findAny()
                .orElse(null);

        if (checkout != null) checkout.hasReturned = !checkout.hasReturned;

        return checkout;
    }

    public boolean isCheckedOut(int movieId){
        return this.checkoutMovieList.stream().anyMatch(checkoutMovie -> checkoutMovie.movieId == movieId && !checkoutMovie.hasReturned);
    }
}
