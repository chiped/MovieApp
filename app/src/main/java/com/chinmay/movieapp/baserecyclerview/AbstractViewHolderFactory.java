package com.chinmay.movieapp.baserecyclerview;

import android.view.ViewGroup;

import com.chinmay.movieapp.movielist.MovieViewHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChiP on 4/2/2016.
 */
public abstract class AbstractViewHolderFactory {

    private static final Map<Integer, AbstractViewHolderFactory> viewHolderFactoryMap = new HashMap<Integer, AbstractViewHolderFactory>() {
        {
            put(RecyclerViewItemWrapper.MOVIE, new MovieViewHolder.MovieViewHolderFactory());
        }
    };

    public static AbstractViewHolderFactory getViewHolderFactory(int viewType) {
        return viewHolderFactoryMap.get(viewType);
    }

    protected abstract BaseRecyclerViewHolder create(ViewGroup parent);
}