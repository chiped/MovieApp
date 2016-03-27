package com.chinmay.movieapp.moviedetails.model;

import java.util.List;

/**
 * Created by ChiP on 3/27/2016.
 */
public class HorizontalImageListItem extends ListItem<String> {

    public HorizontalImageListItem(String title, List<String> value) {
        super(title, value);
        this.itemType = ItemType.HORIZONTAL_IMAGE_LIST;
    }
}
