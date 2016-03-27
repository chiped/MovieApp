package com.chinmay.movieapp.moviedetails;

import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.model.MovieDetail;
import com.chinmay.movieapp.moviedetails.model.DetailItem;
import com.chinmay.movieapp.moviedetails.model.ExpandableTextItem;
import com.chinmay.movieapp.moviedetails.model.TextItem;
import com.chinmay.movieapp.network.NetworkManager;
import com.chinmay.movieapp.utils.StringUtils;
import com.chinmay.movieapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by ChiP on 3/26/2016.
 */
public class MovieDetailsPresenter {

    public Movie movie;
    public List<DetailItem> list = new ArrayList<>();
    private IMovieDetailsView movieDetailsView;

    public MovieDetailsPresenter(IMovieDetailsView movieDetailsView) {
        this.movieDetailsView = movieDetailsView;
    }

    public void onCreate() {
        NetworkManager.getInstance().getMovieDetail(movie.getId(), new Callback<MovieDetail>() {
            @Override
            public void onResponse(Response<MovieDetail> response, Retrofit retrofit) {
                processResponse(response.body());
                movieDetailsView.refreshList();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void processResponse(MovieDetail movieDetail) {
        if(!Utils.isEmptyOrNull(movieDetail.getGenres())) {
            list.add(new TextItem("Genre(s):", StringUtils.asStringSeparated(movieDetail.getGenres(), ", ")));
        }

        if(movieDetail.getReleaseDate() != null) {
            list.add(new TextItem("Release Date:", movieDetail.getReleaseDate().toString()));
        }

        if(movieDetail.getRuntime() != 0) {
            list.add(new TextItem("Runtime:", String.format("%.0f minutes", movieDetail.getRuntime())));
        }

        if(movieDetail.getVoteAverage() != 0) {
            list.add(new TextItem("Rating:", String.format("%.2f (%d votes)", movieDetail.getVoteAverage(), movieDetail.getVoteCount())));
        }

        if(!StringUtils.empty(movieDetail.getOverview())) {
            list.add(new ExpandableTextItem("Overview:", movieDetail.getOverview()));
        }

        if(movieDetail.getBudget() != 0) {
            list.add(new TextItem("Budget:", String.format("$%.0f", movieDetail.getBudget())));
        }

        if(movieDetail.getRevenue() != 0) {
            list.add(new TextItem("Revenue:", String.format("$%.0f", movieDetail.getRevenue())));
        }

        if(!Utils.isEmptyOrNull(movieDetail.getLanguages())) {
            list.add(new TextItem("Language(s):", StringUtils.asStringSeparated(movieDetail.getLanguages(), ", ")));
        }

        if(!Utils.isEmptyOrNull(movieDetail.getCountries())) {
            list.add(new TextItem("Location(s):", StringUtils.asStringSeparated(movieDetail.getCountries(), ", ")));
        }

        if(!Utils.isEmptyOrNull(movieDetail.getProductionCompanies())) {
            list.add(new TextItem("Production Company(s):", StringUtils.asStringSeparated(movieDetail.getProductionCompanies(), ", ")));
        }


    }

}
