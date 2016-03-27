package com.chinmay.movieapp.moviedetails.model;

import com.chinmay.movieapp.model.Cast;

import java.util.List;

/**
 * Created by ChiP on 3/27/2016.
 */
public class HorizontalPeopleListItem extends ListItem<Cast> {

    public HorizontalPeopleListItem(String title, List<Cast> value) {
        super(title, value);
        this.itemType = ItemType.HORIZONTAL_PEOPLE_LIST;
    }
}
