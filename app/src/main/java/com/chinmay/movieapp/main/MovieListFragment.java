package com.chinmay.movieapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.R;

/**
 * Created by ChiP on 1/6/2016.
 */
public class MovieListFragment extends Fragment {

    private int selectedPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        return view;
    }

    public static Fragment newInstance(int position) {
        MovieListFragment fragment = new MovieListFragment();
        fragment.selectedPosition = position;

        return fragment;
    }
}
