package com.chinmay.movieapp.moviedetails;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.moviedetails.model.HorizontalPeopleListItem;

/**
 * Created by ChiP on 3/27/2016.
 */
public class CastListViewHolder extends DetailsAdapter.RecyclerViewViewHolder<HorizontalPeopleListItem> {
    private TextView titleTextView;
    private RecyclerView valueRecyclerView;

    public CastListViewHolder(View view) {
        super(view);
        titleTextView = (TextView) view.findViewById(R.id.title);
        valueRecyclerView = (RecyclerView) view.findViewById(R.id.value);
        valueRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    void bind(HorizontalPeopleListItem data) {
        titleTextView.setText(data.getTitle());
        DetailsCastAdapter castAdapter = new DetailsCastAdapter(itemView.getContext(), data.getList());
        valueRecyclerView.setAdapter(castAdapter);
    }
}
