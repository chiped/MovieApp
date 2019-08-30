package com.chinmay.movieapp.categories;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.categories.model.GenreWrapper;

import java.util.List;

/**
 * Created by ChiP on 3/28/2016.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    private final Context context;
    private final List<GenreWrapper> dataset;
    private CategoryClickListener clickListener;

    public CategoriesAdapter(Context context, List<GenreWrapper> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final GenreWrapper.ItemType itemType = GenreWrapper.ItemType.fromInt(viewType);
        final int layout;
        if (itemType == GenreWrapper.ItemType.HEADER) {
            layout = R.layout.category_header_view;
        } else {
            layout = R.layout.category_item_view;
        }
        final View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.bindView(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataset.get(position).getType().getValue();
    }

    public void setClickListener(CategoryClickListener clickListener) {
        this.clickListener = clickListener;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }

        public void bindView(GenreWrapper genreWrapper) {
            switch (genreWrapper.getType()) {
                case HEADER:
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(genreWrapper.getText());
                    itemView.setEnabled(false);
                    break;
                case ITEM:
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(genreWrapper.getGenre().getName());
                    itemView.setEnabled(true);
                    itemView.setOnClickListener(this);
                    break;
                case EMPTY:
                    textView.setVisibility(View.INVISIBLE);
                    itemView.setEnabled(false);
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            if(clickListener != null) {
                clickListener.onClick(dataset.get(getLayoutPosition()));
            }
        }
    }

    public interface CategoryClickListener {
        void onClick(GenreWrapper genreWrapper);
    }
}