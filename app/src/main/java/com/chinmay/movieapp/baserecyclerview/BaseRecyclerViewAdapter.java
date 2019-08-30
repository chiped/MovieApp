package com.chinmay.movieapp.baserecyclerview;

import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ChiP on 4/2/2016.
 */
public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    private final IViewClickListener clickListener;
    private List<RecyclerViewItemWrapper> dataset;

    public BaseRecyclerViewAdapter(List<RecyclerViewItemWrapper> dataset, IViewClickListener clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return AbstractViewHolderFactory.getViewHolderFactory(viewType).create(parent);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        holder.bind(position, dataset.get(position).getItem(), clickListener);
    }

    @Override
    public int getItemViewType(int position) {
        return dataset.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
