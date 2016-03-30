package com.chinmay.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ChiP on 3/28/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Genre {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GenreList {
        public List<Genre> genres;
    }

    public static class ComboGenreResponse {
        public List<Genre> movieGenres;
        public List<Genre> tvGenres;
    }
}
