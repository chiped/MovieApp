package com.chinmay.movieapp.movielist.category;

import android.content.Intent;
import android.os.Bundle;

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
    private GenreWrapper genreWrapper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        genreWrapper = getArguments().getParcelable(GENRE_WRAPPER);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupLoaders() {
        if(genreWrapper.getGenreType() == GenreWrapper.GenreType.MOVIE) {
            addDataLoader(new CategoryMovieDataLoader(genreWrapper));
        } else {
            addDataLoader(new CategoryTVDataLoader(genreWrapper));
        }
    }

    @Override
    public void onClick(Object item, int position) {
        if(genreWrapper.getGenreType() == GenreWrapper.GenreType.MOVIE) {
            Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
            intent.putExtra(Constants.MOVIE_EXTRA, (Movie) item);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }
}
