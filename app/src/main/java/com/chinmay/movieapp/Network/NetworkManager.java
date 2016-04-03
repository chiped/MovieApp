package com.chinmay.movieapp.network;

import com.chinmay.movieapp.Constants;
import com.chinmay.movieapp.model.Cast;
import com.chinmay.movieapp.model.Genre;
import com.chinmay.movieapp.model.ImageUrlResult;
import com.chinmay.movieapp.model.MovieDetail;
import com.chinmay.movieapp.model.MovieListResult;
import com.chinmay.movieapp.utils.Func1;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by ChiP on 1/6/2016.
 */
public class NetworkManager {
    private static Retrofit restAdapter = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build();

    private static TMDBService service = restAdapter.create(TMDBService.class);

    private static NetworkManager instance = new NetworkManager();

    public static NetworkManager getInstance() {
        return instance;
    }

    NetworkManager() {
        restAdapter.client().interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                HttpUrl url = chain.request().httpUrl()
                        .newBuilder()
                        .addQueryParameter("api_key", Constants.API_KEY)
                        .build();
                Request request = chain.request().newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });
    }

    public int getMovieList(String name, Callback<MovieListResult> callback) {
        Call<MovieListResult> call = service.getMovieList(name);
        call.enqueue(callback);
        return  0;
    }

    public int getImageUrls(int id, Callback<ImageUrlResult> callback) {
        Call<ImageUrlResult> call = service.getImageUrls(id);
        call.enqueue(callback);
        return 0;
    }

    public int getCredits(int id, Callback<Cast.CreditsResponse> callback) {
        Call<Cast.CreditsResponse> call = service.getCredits(id);
        call.enqueue(callback);
        return 0;
    }

    public int getMovieDetail(int id, Callback<MovieDetail> callback) {
        Call<MovieDetail> call = service.getMovieDetails(id);
        call.enqueue(callback);
        return 0;
    }

    public int getSimilarMovies(int id, Callback<MovieListResult> callback) {
        Call<MovieListResult> call = service.getSimilarMovies(id);
        call.enqueue(callback);
        return  0;
    }

    public int getMovieGenres(Callback<Genre.GenreList> callback) {
        Call<Genre.GenreList> call = service.getMovieGenres();
        call.enqueue(callback);
        return  0;
    }

    public int getTVGenres(Callback<Genre.GenreList> callback) {
        Call<Genre.GenreList> call = service.getTVGenres();
        call.enqueue(callback);
        return  0;
    }

    public void getGenres(final Func1<Genre.ComboGenreResponse> callback) {
        getMovieGenres(new Callback<Genre.GenreList>() {
            @Override
            public void onResponse(final retrofit.Response<Genre.GenreList> movieResponse, Retrofit retrofit) {
                getTVGenres(new Callback<Genre.GenreList>() {
                    @Override
                    public void onResponse(retrofit.Response<Genre.GenreList> tvResponse, Retrofit retrofit) {
                        Genre.ComboGenreResponse comboGenreResponse = new Genre.ComboGenreResponse();
                        comboGenreResponse.movieGenres = movieResponse.body().genres;
                        comboGenreResponse.tvGenres = tvResponse.body().genres;
                        callback.execute(comboGenreResponse);
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public int getMoviesForGenre(int id, Callback<MovieListResult> callback) {
        Call<MovieListResult> call = service.getMoviesForGenre(id);
        call.enqueue(callback);
        return  0;
    }

}
