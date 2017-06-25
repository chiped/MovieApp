package com.chinmay.movieapp.movielist;

import android.os.Bundle;

import com.chinmay.movieapp.baserecyclerview.BaseRecyclerViewActivity;
import com.chinmay.movieapp.baserecyclerview.BaseRecylerViewFragment;
import com.chinmay.movieapp.categories.model.GenreWrapper;
import com.chinmay.movieapp.movielist.category.CategoryMovieListFragment;

/**
 * Created by ChiP on 4/2/2016.
 */
public class MovieListActivity extends BaseRecyclerViewActivity {

    private GenreWrapper genreWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        genreWrapper = getIntent().getParcelableExtra(CategoryMovieListFragment.GENRE_WRAPPER);
        super.onCreate(savedInstanceState);
    }

    @Override
    public BaseRecylerViewFragment getFragment() {
        CategoryMovieListFragment fragment = new CategoryMovieListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CategoryMovieListFragment.GENRE_WRAPPER, genreWrapper);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected String getActivityTitle() {
        return genreWrapper.getGenre().getName() + " (" + genreWrapper.getGenreType().name() + ")";
    }
}
