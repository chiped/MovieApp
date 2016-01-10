package com.chinmay.movieapp.moviedetails;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ImageView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

/**
 * Created by ChiP on 1/10/2016.
 */
public class MovieDetailsActivity extends AppCompatActivity {

    private Movie movie;
    private ImageView imageView;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie = getIntent().getParcelableExtra("MOVIE");
        configureView();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_movie_detail, MovieDetailsFragment.getInstance(movie))
                .commit();
    }

    private void configureView() {
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.detail_collapsing_toolbar);
        toolbar = (Toolbar) findViewById(R.id.movie_detail_toolbar);
        imageView = (ImageView) findViewById(R.id.movie_detail_image);

        collapsingToolbar.setTitle(movie.getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(this).load(HttpUtils.getSmallUrl(movie.getPosterPath()))
                .into(imageView);
        Picasso.with(this).load(HttpUtils.getLargeUrl(movie.getPosterPath()))
                .placeholder(imageView.getDrawable())
                .into(imageView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.accent));
        }
    }
}
