package com.chinmay.movieapp.moviedetails.model;

/**
 * Created by ChiP on 3/26/2016.
 */
public class ExpandableTextItem extends TextItem {

    public ExpandableTextItem(String title, String value) {
        super(title, value);
        itemType = ItemType.EXPANDABLE_TEXT;
    }
}
