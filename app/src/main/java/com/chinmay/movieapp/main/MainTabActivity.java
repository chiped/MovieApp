package com.chinmay.movieapp.main;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.chinmay.movieapp.R;

/**
 * Created by ChiP on 1/5/2016.
 */
public class MainTabActivity extends AppCompatActivity {

    private static final int[] BOTTOM_MENUS = {R.id.menu_home, R.id.menu_genres, R.id.menu_trending, R.id.menu_favorites};

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));

        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(new MainViewPagerAdapter(getApplicationContext(), getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.setSelectedItemId(BOTTOM_MENUS[position]);
            }
        });

        bottomNavigationView = findViewById(R.id.main_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                for (int i=0; i<BOTTOM_MENUS.length; i++) {
                    if (BOTTOM_MENUS[i] == item.getItemId()) {
                        viewPager.setCurrentItem(i);
                        break;
                    }
                }
                return true;
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.accent));
        }
    }
}
