package com.chinmay.movieapp.moviedetails.model;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public abstract class ListItem<T> extends DetailItem {
    protected List<T> list;

    protected ListItem(String title, List<T> value) {
        this.title = title;
        this.list = value;
    }

    public List<T> getList() {
        return list;
    }
}
