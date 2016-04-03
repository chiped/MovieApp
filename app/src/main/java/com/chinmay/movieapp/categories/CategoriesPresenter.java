package com.chinmay.movieapp.categories;

import com.chinmay.movieapp.categories.model.GenreWrapper;
import com.chinmay.movieapp.model.Genre;
import com.chinmay.movieapp.network.NetworkManager;
import com.chinmay.movieapp.utils.Func1;
import com.chinmay.movieapp.utils.StringUtils;
import com.chinmay.movieapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChiP on 3/28/2016.
 */
public class CategoriesPresenter {

    private final CategoriesView categoriesView;
    private final boolean singleColumn;
    List<GenreWrapper> genres = new ArrayList<>();

    public CategoriesPresenter(CategoriesView categoriesView, boolean singleColumn) {
        this.categoriesView = categoriesView;
        this.singleColumn = singleColumn;
    }

    public void onCreate() {
        NetworkManager.getInstance().getGenres(new Func1<Genre.ComboGenreResponse>() {
            @Override
            public void execute(Genre.ComboGenreResponse comboGenreResponse) {
                processResponse(comboGenreResponse);
                categoriesView.refreshList();
            }
        });
    }

    private void processResponse(Genre.ComboGenreResponse response) {
        genres.clear();
        final List<Genre> movieGenres = response.movieGenres;
        final List<Genre> tvGenres = response.tvGenres;

        if(singleColumn) {
            processSingleColumnItems(movieGenres, tvGenres);
        } else {
            processMultiColumnItems(movieGenres, tvGenres);
        }
    }

    private void processMultiColumnItems(List<Genre> movieGenres, List<Genre> tvGenres) {
        if (!Utils.isEmptyOrNull(movieGenres)) {
            genres.add(new GenreWrapper.Builder().setText("Movies").build());
        }
        if (!Utils.isEmptyOrNull(tvGenres)) {
            genres.add(new GenreWrapper.Builder().setText("TV").build());
        }
        for(int i=0; i<movieGenres.size() || i<tvGenres.size(); i++) {
            if(i<movieGenres.size()) {
                genres.add(new GenreWrapper.Builder().setGenre(movieGenres.get(i)).setGenreType(GenreWrapper.GenreType.MOVIE).build());
            } else {
                genres.add(new GenreWrapper.Builder().build());
            }

            if(i<tvGenres.size()) {
                genres.add(new GenreWrapper.Builder().setGenre(tvGenres.get(i)).setGenreType(GenreWrapper.GenreType.MOVIE).build());
            } else {
                genres.add(new GenreWrapper.Builder().build());
            }
        }
    }

    private void processSingleColumnItems(List<Genre> movieGenres, List<Genre> tvGenres) {
        if (!Utils.isEmptyOrNull(movieGenres)) {
            genres.add(new GenreWrapper.Builder().setText("Movies").build());
            for (Genre genre : movieGenres) {
                genres.add(new GenreWrapper.Builder().setGenre(genre).setGenreType(GenreWrapper.GenreType.MOVIE).build());
            }
        }

        if (!Utils.isEmptyOrNull(tvGenres)) {
            genres.add(new GenreWrapper.Builder().setText("TV").build());
            for (Genre genre : tvGenres) {
                genres.add(new GenreWrapper.Builder().setGenre(genre).setGenreType(GenreWrapper.GenreType.TV).build());
            }
        }
    }

    public interface CategoriesView {
        void refreshList();
    }
}
