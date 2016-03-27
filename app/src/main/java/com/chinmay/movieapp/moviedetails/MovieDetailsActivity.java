package com.chinmay.movieapp.moviedetails;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.chinmay.movieapp.Constants;
import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

/**
 * Created by ChiP on 1/10/2016.
 */
public class MovieDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Movie movie;
    private ImageView imageView;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie = (Movie) (savedInstanceState != null ? savedInstanceState.getParcelable(Constants.MOVIE_EXTRA) :
                         getIntent().getParcelableExtra(Constants.MOVIE_EXTRA));
        configureView();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_movie_detail, MovieDetailsFragment.getInstance(movie))
                .commit();
    }

    private void configureView() {
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.detail_collapsing_toolbar);
        toolbar = (Toolbar) findViewById(R.id.movie_detail_toolbar);
        imageView = (ImageView) findViewById(R.id.movie_detail_image);

        collapsingToolbar.setTitle(movie.getDisplayTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(this).load(HttpUtils.getSmallUrl(movie.getPosterPath()))
                .into(imageView);
        Picasso.with(this).load(HttpUtils.getLargeUrl(movie.getPosterPath()))
                .placeholder(imageView.getDrawable())
                .into(imageView);
        imageView.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.accent));
        }

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra(Constants.PLACEHOLDER_URL, HttpUtils.getSmallUrl(movie.getPosterPath()));
        intent.putExtra(Constants.IMAGE_URL, HttpUtils.getLargeUrl(movie.getPosterPath()));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Constants.MOVIE_EXTRA, movie);
    }
}
