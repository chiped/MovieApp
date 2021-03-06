package com.chinmay.movieapp.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.Constants;
import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.model.MovieListResult;
import com.chinmay.movieapp.moviedetails.MovieDetailsActivity;
import com.chinmay.movieapp.network.NetworkManager;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by ChiP on 1/6/2016.
 */
public class MovieListFragment extends Fragment implements MovieAdapter.MovieClickListener {

    private int selectedPosition;
    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        movieList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.movie_list_recylerview);
        layoutManager = new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.movie_list_columns));
        recyclerView.setLayoutManager(layoutManager);
        MovieAdapter adapter = new MovieAdapter(getActivity(), movieList, R.layout.movie_list_row);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        loadMovies();
        return view;
    }

    private void loadMovies() {
        NetworkManager.getInstance().getMovieList(
                Constants.LIST_TYPE[selectedPosition],
                new Callback<MovieListResult>() {
                    @Override
                    public void onResponse(Response<MovieListResult> response, Retrofit retrofit) {
                        movieList.addAll(response.body().getResults());
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                    }
                });
    }

    public static Fragment newInstance(int position) {
        MovieListFragment fragment = new MovieListFragment();
        fragment.selectedPosition = position;

        return fragment;
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
        intent.putExtra(Constants.MOVIE_EXTRA, movieList.get(position));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
