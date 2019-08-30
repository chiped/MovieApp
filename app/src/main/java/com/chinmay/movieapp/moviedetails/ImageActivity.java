package com.chinmay.movieapp.moviedetails;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.chinmay.movieapp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by ChiP on 1/10/2016.
 */
public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = (ImageView) findViewById(R.id.image);
        toolbar = (Toolbar) findViewById(R.id.image_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setElevation(0);
        String url = getIntent().getStringExtra("IMAGE_URL");
        String placeholder = getIntent().getStringExtra("PLACEHOLDER_URL");

        Picasso.get()
                .load(placeholder)
                .into(imageView);

        Picasso.get()
                .load(url)
                .placeholder(imageView.getDrawable())
                .into(imageView);
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
}
