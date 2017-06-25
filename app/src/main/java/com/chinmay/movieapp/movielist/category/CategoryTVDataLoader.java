package com.chinmay.movieapp.movielist.category;

import com.chinmay.movieapp.baserecyclerview.IFragmentDataLoader;
import com.chinmay.movieapp.baserecyclerview.RecyclerViewItemWrapper;
import com.chinmay.movieapp.categories.model.GenreWrapper;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.model.MovieListResult;
import com.chinmay.movieapp.network.NetworkManager;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by ChiP on 4/3/2016.
 */
public class CategoryTVDataLoader implements IFragmentDataLoader {
    private final GenreWrapper genreWrapper;

    public CategoryTVDataLoader(GenreWrapper genreWrapper) {
        this.genreWrapper = genreWrapper;
    }

    @Override
    public void process(final List<RecyclerViewItemWrapper> list, final LoaderCallBack callBack) {
        NetworkManager.getInstance().getTVForGenre(genreWrapper.getGenre().getId(), new Callback<MovieListResult>() {
            @Override
            public void onResponse(Response<MovieListResult> response, Retrofit retrofit) {
                for (Movie movie : response.body().getResults()) {
                    list.add(new RecyclerViewItemWrapper(RecyclerViewItemWrapper.TV, movie));
                    callBack.onFinish();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
