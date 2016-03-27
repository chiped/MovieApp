package com.chinmay.movieapp.moviedetails.model;

import java.util.List;

/**
 * Created by ChiP on 3/27/2016.
 */
public class HorizontalTextListItem extends ListItem<String> {
    public HorizontalTextListItem(String title, List<String> value) {
        super(title, value);
        this.itemType = ItemType.HORIZONTAL_TEXT_LIST;
    }
}
