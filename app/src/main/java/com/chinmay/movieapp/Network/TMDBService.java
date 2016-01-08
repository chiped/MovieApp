package com.chinmay.movieapp.network;

import com.chinmay.movieapp.model.MovieListResult;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ChiP on 1/6/2016.
 */
public interface TMDBService {

    @GET("movie/{name}")
    Call<MovieListResult> getMovieList(@Path("name") String name);
}
