package com.chinmay.movieapp.categories;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.categories.model.GenreWrapper;
import com.chinmay.movieapp.movielist.MovieListActivity;

import static com.chinmay.movieapp.movielist.category.CategoryMovieListFragment.GENRE_WRAPPER;

/**
 * Created by ChiP on 3/28/2016.
 */
public class CategoriesFragment extends Fragment implements CategoriesPresenter.CategoriesView, CategoriesAdapter.CategoryClickListener {

    private RecyclerView recyclerView;
    private CategoriesPresenter presenter;
    private CategoriesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        final int spanCount = getResources().getInteger(R.integer.categories_list_columns);
        presenter = new CategoriesPresenter(this, spanCount==1);

        recyclerView = (RecyclerView) view.findViewById(R.id.movie_list_recylerview);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), spanCount);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoriesAdapter(getActivity(), presenter.genres);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        presenter.onCreate();
        return view;
    }

    @Override
    public void refreshList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(GenreWrapper genreWrapper) {
        Intent intent = new Intent(getContext(), MovieListActivity.class);
        intent.putExtra(GENRE_WRAPPER, genreWrapper);
        startActivity(intent);
    }
}
