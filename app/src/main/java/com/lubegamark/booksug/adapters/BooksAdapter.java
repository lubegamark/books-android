package com.lubegamark.booksug.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lubegamark.booksug.R;
import com.squareup.picasso.Picasso;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitleView;
        public TextView mAuthorView;
        public ImageView mThumbnailView;

        public ViewHolder(View v) {
            super(v);
            mTitleView =  (TextView) v.findViewById(R.id.book_list_title);
            mAuthorView = (TextView)  v.findViewById(R.id.book_list_author);
            mThumbnailView = (ImageView)  v.findViewById(R.id.book_list_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BooksAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d("Item", mDataset[position]);
        holder.mTitleView.setText(mDataset[position]);
        holder.mAuthorView.setText(mDataset[position]);
        Context context = holder.mThumbnailView.getContext();
        Picasso.with(context)
                .load('/')
                .placeholder(R.drawable.ic_book)
                .error(R.drawable.ic_book)
                .into(holder.mThumbnailView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
