package com.chinmay.movieapp.moviedetails.model;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public class VerticalListItem<T> extends ListItem {

    public VerticalListItem(String title, List<T> value) {
        super(title, value);
        this.itemType = ItemType.VERTICAL_LIST;
    }
}
