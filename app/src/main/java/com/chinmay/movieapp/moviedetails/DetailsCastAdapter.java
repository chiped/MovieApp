package com.chinmay.movieapp.moviedetails;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.model.Cast;
import com.chinmay.movieapp.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ChiP on 1/26/2016.
 */
public class DetailsCastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Cast> dataset;

    public DetailsCastAdapter(Context context, List<Cast> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cast_cell, parent, false);
        CastViewHolder vh = new CastViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        CastViewHolder holder = (CastViewHolder) viewHolder;
        Cast cast = dataset.get(position);
        holder.name.setText(cast.getName());
        holder.character.setText(cast.getCharacter());
        String url = HttpUtils.getProfilePhotoUrl(cast.getProfilePath());
        Picasso.get()
                .load(url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    private static class CastViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView character;

        public CastViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.cast_image);
            name = (TextView) view.findViewById(R.id.cast_name);
            character = (TextView) view.findViewById(R.id.cast_character);
        }
    }
}
