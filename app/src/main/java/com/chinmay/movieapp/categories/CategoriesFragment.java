package com.chinmay.movieapp.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.R;

/**
 * Created by ChiP on 3/28/2016.
 */
public class CategoriesFragment extends Fragment implements CategoriesPresenter.CategoriesView {

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
        recyclerView.setAdapter(adapter);

        presenter.onCreate();
        return view;
    }

    @Override
    public void refreshList() {
        adapter.notifyDataSetChanged();
    }
}
