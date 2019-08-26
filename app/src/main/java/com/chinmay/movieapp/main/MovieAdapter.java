package com.chinmay.movieapp.main;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ChiP on 1/9/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter {

    private final Context context;
    @LayoutRes private final int rowLayout;
    private MovieClickListener clickListener;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> dataset, @LayoutRes int rowLayout) {
        this.context = context;
        this.movieList = dataset;
        this.rowLayout = rowLayout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(rowLayout, parent, false);
        MovieRowViewHolder vh = new MovieRowViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MovieRowViewHolder holder = (MovieRowViewHolder) viewHolder;
        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getDisplayTitle());
        holder.ratingTextView.setText(movie.getRating()>0?String.format("%.1f", movie.getRating()):"");
        CharSequence date = DateFormat.format("dd MMM yyyy", movie.getReleaseDate());
        holder.releaseDateTextView.setText(date);
        Picasso.get()
                .load(HttpUtils.getSmallUrl(movie.getPosterPath()))
                .error(R.drawable.no_poster)
                .placeholder(R.drawable.no_poster)
                .into(holder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setClickListener(MovieClickListener clickListener) {
        this.clickListener = clickListener;
    }

    private class MovieRowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(clickListener != null) {
                clickListener.onClick(view, getLayoutPosition());
            }
        }
    }

    public interface MovieClickListener {
        void onClick(View view, int position);
    }
}