package com.chinmay.movieapp.moviedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.Constants;
import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Cast;
import com.chinmay.movieapp.model.ImageUrlResult;
import com.chinmay.movieapp.model.Movie;
import com.chinmay.movieapp.network.NetworkManager;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by ChiP on 1/7/2016.
 */
public class MovieDetailsFragment extends Fragment implements IMovieDetailsView {


    private Movie movie;
    private RecyclerView galleryRecylerView;
    private RecyclerView castRecylerView;
    private RecyclerView detailsRecyclerView;
    private List<String> imageUrls;
    private List<Cast> cast;
    private DetailsGalleryAdapter galleryAdapter;
    private DetailsCastAdapter castAdapter;

    private MovieDetailsPresenter presenter;
    private DetailsAdapter detailsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        if(savedInstanceState != null) {
            movie = savedInstanceState.getParcelable(Constants.MOVIE_EXTRA);
        }

        presenter = new MovieDetailsPresenter(this);
        presenter.movie = movie;
        presenter.onCreate();

//        setupImageGallery(view);
//        setupCastGallery(view);
//
//        loadImageUrls();
//        loadCredits();

        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        detailsRecyclerView = (RecyclerView) view.findViewById(R.id.details_recycler_view);
        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        detailsAdapter = new DetailsAdapter(getActivity(), presenter.list);
        detailsRecyclerView.setAdapter(detailsAdapter);
    }

//    private void setupImageGallery(View view) {
//        galleryRecylerView = (RecyclerView) view.findViewById(R.id.details_gallery);
//        galleryRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false));
//        imageUrls = new ArrayList<>();
//        galleryAdapter = new DetailsGalleryAdapter(getActivity(), imageUrls);
//        galleryRecylerView.setAdapter(galleryAdapter);
//    }
//
//    private void setupCastGallery(View view) {
//        castRecylerView = (RecyclerView) view.findViewById(R.id.details_cast_gallery);
//        castRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        cast = new ArrayList<>();
//        castAdapter = new DetailsCastAdapter(getActivity(), cast);
//        castRecylerView.setAdapter(castAdapter);
//    }

    private void loadImageUrls() {
        NetworkManager.getInstance().getImageUrls(movie.getId(), new Callback<ImageUrlResult>() {

            @Override
            public void onResponse(Response<ImageUrlResult> response, Retrofit retrofit) {
                imageUrls.addAll(response.body().getBackdrops());
                galleryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }

    private void loadCredits() {
        NetworkManager.getInstance().getCredits(movie.getId(), new Callback<Cast.CreditsResponse>() {

            @Override
            public void onResponse(Response<Cast.CreditsResponse> response, Retrofit retrofit) {
                cast.addAll(response.body().cast);
                castAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }

    public static Fragment getInstance(Movie movie) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        fragment.movie = movie;
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Constants.MOVIE_EXTRA, movie);
    }

    @Override
    public void refreshList() {
        detailsAdapter.notifyDataSetChanged();
    }
}
