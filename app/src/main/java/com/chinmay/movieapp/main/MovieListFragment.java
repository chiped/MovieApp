package com.chinmay.movieapp.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinmay.movieapp.Constants;
import com.chinmay.movieapp.Network.NetworkManager;
import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.model.MovieListResult;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by ChiP on 1/6/2016.
 */
public class MovieListFragment extends Fragment {

    private int selectedPosition;
    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        movieList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.movie_list_recylerview);
        layoutManager = new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.movie_list_columns));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MovieListAdapter());

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

    public static class MovieRowViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView ratingTextView;
        TextView releaseDateTextView;
        ImageView posterImageView;

        public MovieRowViewHolder(View view) {
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.movie_title);
            ratingTextView = (TextView) view.findViewById(R.id.movie_rating);
            releaseDateTextView = (TextView) view.findViewById(R.id.movie_date);
            posterImageView = (ImageView) view.findViewById(R.id.movie_row_poster);
        }
    }
    private class MovieListAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.movie_list_row, parent, false);
            MovieRowViewHolder vh = new MovieRowViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            MovieRowViewHolder holder = (MovieRowViewHolder) viewHolder;
            Movie movie = movieList.get(position);
            holder.titleTextView.setText(movie.getTitle());
            holder.ratingTextView.setText(movie.getRating()>0?String.format("%.1f", movie.getRating()):"");
            CharSequence date = DateFormat.format("dd MMM yyyy", movie.getReleaseDate());
            holder.releaseDateTextView.setText(date);
            Picasso.with(getActivity())
                    .load(HttpUtils.getSmallUrl(movie.getPosterPath()))
                    .error(R.drawable.no_poster)
                    .placeholder(R.drawable.no_poster)
                    .into(holder.posterImageView);
        }

        @Override
        public int getItemCount() {
            return movieList.size();
        }
    }
}
