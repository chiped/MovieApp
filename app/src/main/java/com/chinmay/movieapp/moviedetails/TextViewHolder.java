package com.chinmay.movieapp.moviedetails;

import android.view.View;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.moviedetails.model.TextItem;

/**
 * Created by ChiP on 3/27/2016.
 */
public class TextViewHolder extends DetailsAdapter.RecyclerViewViewHolder<TextItem> {
    private TextView titleTextView;
    private TextView valueTextView;

    public TextViewHolder(View view) {
        super(view);
        titleTextView = (TextView) view.findViewById(R.id.title);
        valueTextView = (TextView) view.findViewById(R.id.value);
    }

    @Override
    void bind(TextItem item) {
        titleTextView.setText(item.getTitle());
        valueTextView.setText(item.getValue());
    }

}
