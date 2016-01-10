package com.chinmay.movieapp.moviedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Movie;

/**
 * Created by ChiP on 1/7/2016.
 */
public class MovieDetailsFragment extends Fragment {


    private Movie movie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        return view;
    }

    public static Fragment getInstance(Movie movie) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        fragment.movie = movie;
        return fragment;
    }
}
