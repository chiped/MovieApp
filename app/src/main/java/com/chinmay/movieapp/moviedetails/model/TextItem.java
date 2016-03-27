package com.chinmay.movieapp.moviedetails.model;

/**
 * Created by ChiP on 3/26/2016.
 */
public class TextItem extends DetailItem {
    private String value;

    public TextItem(String title, String value) {
        this.title = title;
        this.value = value;
        this.itemType = ItemType.TEXT;
    }

    public String getValue() {
        return value;
    }
}
