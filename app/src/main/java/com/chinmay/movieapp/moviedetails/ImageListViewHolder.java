package com.chinmay.movieapp.moviedetails;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.moviedetails.model.HorizontalImageListItem;

/**
 * Created by ChiP on 3/27/2016.
 */
public class ImageListViewHolder extends DetailsAdapter.RecyclerViewViewHolder<HorizontalImageListItem> {
    private TextView titleTextView;
    private RecyclerView valueRecyclerView;
    public ImageListViewHolder(View view) {
        super(view);
        titleTextView = (TextView) view.findViewById(R.id.title);
        valueRecyclerView = (RecyclerView) view.findViewById(R.id.value);
        valueRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    void bind(HorizontalImageListItem data) {
        titleTextView.setText(data.getTitle());
        DetailsGalleryAdapter galleryAdapter = new DetailsGalleryAdapter(itemView.getContext(), data.getList());
        valueRecyclerView.setAdapter(galleryAdapter);
    }
}
