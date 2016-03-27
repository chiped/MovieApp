package com.chinmay.movieapp.moviedetails.model;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public class VerticalReviewsListItem extends ListItem<String> {

    public VerticalReviewsListItem(String title, List<String> value) {
        super(title, value);
        this.itemType = ItemType.VERTICAL_REVIEWS_LIST;
    }
}
