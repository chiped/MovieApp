package com.chinmay.movieapp.moviedetails;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.main.MovieAdapter;
import com.chinmay.movieapp.moviedetails.model.HorizontalMovieListItem;

/**
 * Created by ChiP on 3/27/2016.
 */
public class MovieListAdapter extends DetailsAdapter.RecyclerViewViewHolder<HorizontalMovieListItem> {
    private final TextView titleTextView;
    private final RecyclerView valueRecyclerView;

    public MovieListAdapter(View view) {
        super(view);
        titleTextView = (TextView) view.findViewById(R.id.title);
        valueRecyclerView = (RecyclerView) view.findViewById(R.id.value);
        valueRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    void bind(HorizontalMovieListItem data) {
        titleTextView.setText(data.getTitle());
        MovieAdapter castAdapter = new MovieAdapter(itemView.getContext(), data.getList(), R.layout.movie_cell);
        valueRecyclerView.setAdapter(castAdapter);
    }
}
