package com.chinmay.movieapp.moviedetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ChiP on 1/10/2016.
 */
public class DetailsGalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<String> dataset;

    public DetailsGalleryAdapter(Context context, List<String> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_row, parent, false);
        GalleryViewHolder vh = new GalleryViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        GalleryViewHolder holder = (GalleryViewHolder) viewHolder;
        String url = HttpUtils.get300Url(dataset.get(position));
        Picasso.with(context)
                .load(url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    private static class GalleryViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public GalleryViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageview);
        }
    }
}
