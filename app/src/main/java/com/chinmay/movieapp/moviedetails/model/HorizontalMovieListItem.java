package com.chinmay.movieapp.moviedetails.model;

import com.chinmay.movieapp.model.Movie;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public class HorizontalMovieListItem extends ListItem<Movie> {

    public HorizontalMovieListItem(String title, List<Movie> value) {
        super(title, value);
        this.itemType = ItemType.HORIZONTAL_MOVIE_LIST;
    }
}
