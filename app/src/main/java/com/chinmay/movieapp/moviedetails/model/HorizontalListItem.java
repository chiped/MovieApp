package com.chinmay.movieapp.moviedetails.model;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public class HorizontalListItem<T> extends ListItem {

    public HorizontalListItem(String title, List<T> value) {
        super(title, value);
        this.itemType = ItemType.HORIZONTAL_LIST;
    }
}
