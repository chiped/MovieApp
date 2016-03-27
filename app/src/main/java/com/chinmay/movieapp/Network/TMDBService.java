package com.chinmay.movieapp.network;

import com.chinmay.movieapp.model.Cast;
import com.chinmay.movieapp.model.ImageUrlResult;
import com.chinmay.movieapp.model.MovieDetail;
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

    @GET("movie/{id}/images")
    Call<ImageUrlResult> getImageUrls(@Path("id") int id);

    @GET("movie/{id}/credits")
    Call<Cast.CreditsResponse> getCredits(@Path("id")int id);

    @GET("movie/{id}")
    Call<MovieDetail> getMovieDetails(@Path("id") int id);
}
