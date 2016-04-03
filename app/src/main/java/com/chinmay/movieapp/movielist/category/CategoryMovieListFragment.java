package com.chinmay.movieapp.movielist.category;

import android.content.Intent;

import com.chinmay.movieapp.Constants;
import com.chinmay.movieapp.baserecyclerview.BaseRecylerViewFragment;
import com.chinmay.movieapp.categories.model.GenreWrapper;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.moviedetails.MovieDetailsActivity;

/**
 * Created by ChiP on 4/2/2016.
 */
public class CategoryMovieListFragment extends BaseRecylerViewFragment {

    public static final String GENRE_WRAPPER = "GENRE_WRAPPER";

    @Override
    public void setupLoaders() {
        GenreWrapper genreWrapper = getArguments().getParcelable(GENRE_WRAPPER);
        addDataLoader(new CategoryMovieDataLoader(genreWrapper));
    }

    @Override
    public void onClick(Object item, int position) {
        Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
        intent.putExtra(Constants.MOVIE_EXTRA, (Movie)item);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
