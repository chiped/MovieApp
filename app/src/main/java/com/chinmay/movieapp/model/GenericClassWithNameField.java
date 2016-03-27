package com.chinmay.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ChiP on 3/26/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericClassWithNameField {
    public String name;
}
