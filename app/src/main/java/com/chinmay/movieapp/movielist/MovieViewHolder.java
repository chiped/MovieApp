package com.chinmay.movieapp.movielist;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.baserecyclerview.AbstractViewHolderFactory;
import com.chinmay.movieapp.baserecyclerview.BaseRecyclerViewHolder;
import com.chinmay.movieapp.baserecyclerview.IViewClickListener;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

/**
 * Created by ChiP on 4/2/2016.
 */
public class MovieViewHolder extends BaseRecyclerViewHolder<Movie> {
    TextView titleTextView;
    TextView ratingTextView;
    TextView releaseDateTextView;
    ImageView posterImageView;

    public MovieViewHolder(View view) {
        super(view);
        titleTextView = (TextView) view.findViewById(R.id.movie_title);
        ratingTextView = (TextView) view.findViewById(R.id.movie_rating);
        releaseDateTextView = (TextView) view.findViewById(R.id.movie_date);
        posterImageView = (ImageView) view.findViewById(R.id.movie_row_poster);
    }

    @Override
    protected void bind(final int position, final Movie movie, final IViewClickListener clickListener) {
        titleTextView.setText(movie.getDisplayTitle());
        ratingTextView.setText(movie.getRating()>0?String.format("%.1f", movie.getRating()):"");
        CharSequence date = DateFormat.format("dd MMM yyyy", movie.getReleaseDate());
        releaseDateTextView.setText(date);
        Picasso.with(itemView.getContext())
                .load(HttpUtils.getSmallUrl(movie.getPosterPath()))
                .error(R.drawable.no_poster)
                .placeholder(R.drawable.no_poster)
                .into(posterImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null) {
                    clickListener.onClick(movie, position);
                }
            }
        });
    }

    public static class MovieViewHolderFactory extends AbstractViewHolderFactory {

        @Override
        protected BaseRecyclerViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
            return new MovieViewHolder(view);
        }
    }
}
