package com.chinmay.movieapp.moviedetails;

import android.view.View;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.moviedetails.model.ExpandableTextItem;
import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by ChiP on 3/27/2016.
 */
public class ExpandableTextViewHolder extends DetailsAdapter.RecyclerViewViewHolder<ExpandableTextItem> {
    private TextView titleTextView;
    private ExpandableTextView valueTextView;

    public ExpandableTextViewHolder(View view) {
        super(view);
        titleTextView = (TextView) view.findViewById(R.id.title);
        valueTextView = (ExpandableTextView) view.findViewById(R.id.value);
    }

    @Override
    void bind(ExpandableTextItem item) {
        titleTextView.setText(item.getTitle());
        valueTextView.setText(item.getValue());
    }
}
