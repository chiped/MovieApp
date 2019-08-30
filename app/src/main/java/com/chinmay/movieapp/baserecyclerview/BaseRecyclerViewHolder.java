package com.chinmay.movieapp.baserecyclerview;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Created by ChiP on 4/2/2016.
 */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    abstract protected void bind(int position, T item, IViewClickListener clickListener);
}
