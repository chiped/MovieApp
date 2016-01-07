package com.chinmay.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ChiP on 1/6/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieListResult {

    private int page;
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
