package com.chinmay.movieapp.baserecyclerview;

/**
 * Created by ChiP on 4/2/2016.
 */
public class RecyclerViewItemWrapper<I> {
    public static final int MOVIE = 0;

    private int viewType;
    private I item;

    public RecyclerViewItemWrapper(int viewType, I item) {
        this.viewType = viewType;
        this.item = item;
    }

    public int getViewType() {
        return viewType;
    }

    public I getItem() {
        return item;
    }
}
