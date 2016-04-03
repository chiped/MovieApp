package com.chinmay.movieapp.baserecyclerview;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinmay.movieapp.R;

/**
 * Created by ChiP on 4/2/2016.
 */
public abstract class BaseRecylerViewFragment extends Fragment implements IBaseRecylerView, IViewClickListener {

    private RecyclerView recyclerView;
    private BaseRecyclerViewPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);

        presenter = new BaseRecyclerViewPresenter(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getRecyclerViewColumns()));
        recyclerView.setAdapter(new BaseRecyclerViewAdapter(presenter.list, this));

        presenter.onCreate();

        return view;
    }

    protected  @LayoutRes int getLayoutResource() {
        return R.layout.fragment_recyclerview;
    }

    protected int getRecyclerViewColumns() {
        return getResources().getInteger(R.integer.movie_list_columns);
    }

    @Override
    public void refreshList() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    protected void addDataLoader(IFragmentDataLoader loader) {
        presenter.addDataLoader(loader);
    }
}
