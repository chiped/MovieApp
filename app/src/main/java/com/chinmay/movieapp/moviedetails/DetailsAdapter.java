package com.chinmay.movieapp.moviedetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chinmay.movieapp.R;
import com.chinmay.movieapp.moviedetails.model.DetailItem;
import com.chinmay.movieapp.moviedetails.model.ExpandableTextItem;
import com.chinmay.movieapp.moviedetails.model.TextItem;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
public class DetailsAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {

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
            case HORIZONTAL_LIST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_text_row, parent, false);
                viewHolder = new TextViewHolder(view);
                break;
            case VERTICAL_LIST:
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
}

abstract class RecyclerViewViewHolder<T extends DetailItem> extends RecyclerView.ViewHolder {
    public RecyclerViewViewHolder(View itemView) {
        super(itemView);
    }
    abstract void bind(T data);
}

class TextViewHolder extends RecyclerViewViewHolder<TextItem> {
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

class ExpandableTextViewHolder extends RecyclerViewViewHolder<ExpandableTextItem> {
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
