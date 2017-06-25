package com.chinmay.movieapp.baserecyclerview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.utils.StringUtils;

/**
 * Created by ChiP on 3/30/2016.
 */
public abstract class BaseRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getActivityTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.accent));
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, getFragment()).commit();
    }

    public @LayoutRes int getLayoutRes() {
        return R.layout.activity_fragment;
    }

    public abstract BaseRecylerViewFragment getFragment();

    protected String getActivityTitle() {
        return StringUtils.EMPTY_STRING;
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
