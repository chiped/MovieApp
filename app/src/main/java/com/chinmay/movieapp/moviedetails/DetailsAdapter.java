package com.chinmay.movieapp.moviedetails;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.moviedetails.model.DetailItem;
import com.chinmay.movieapp.moviedetails.model.ExpandableTextItem;
import com.chinmay.movieapp.moviedetails.model.HorizontalMovieListItem;
import com.chinmay.movieapp.moviedetails.model.TextItem;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.RecyclerViewViewHolder> {

    private final Context context;
    private final List<DetailItem> dataset;

    public DetailsAdapter(Context context, List<DetailItem> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewViewHolder viewHolder = null;
        View view;
        switch (DetailItem.ItemType.fromInt(viewType)) {
            case TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_text_row, parent, false);
                viewHolder = new TextViewHolder(view);
                break;
            case EXPANDABLE_TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_expandable_text_row, parent, false);
                viewHolder = new ExpandableTextViewHolder(view);
                break;
            case HORIZONTAL_MOVIE_LIST: //TODO correct layout
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_text_row, parent, false);
                viewHolder = new TextViewHolder(view);
                break;
            case HORIZONTAL_PEOPLE_LIST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_list_row, parent, false);
                viewHolder = new CastListViewHolder(view);
                break;
            case HORIZONTAL_IMAGE_LIST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_list_row, parent, false);
                viewHolder = new ImageListViewHolder(view);
                break;
            case VERTICAL_REVIEWS_LIST: //TODO correct layout
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_text_row, parent, false);
                viewHolder = new TextViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        holder.bind(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataset.get(position).getItemType().getValue();
    }

    public abstract static class RecyclerViewViewHolder<T extends DetailItem> extends RecyclerView.ViewHolder {
        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
        }
        abstract void bind(T data);
    }
}
