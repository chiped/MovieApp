package com.chinmay.movieapp.main;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.categories.CategoriesFragment;

/**
 * Created by ChiP on 1/6/2016.
 */
public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int CATEGORIES_POSITION = 1;
    private String[] tabTitles;

    public MainViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        tabTitles = context.getResources().getStringArray(R.array.main_tabs);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == CATEGORIES_POSITION) {
            return new CategoriesFragment();
        }
        return MovieListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
