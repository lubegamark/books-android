package com.lubegamark.booksug.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lubegamark.booksug.adapters.BooksAdapter;
import com.lubegamark.booksug.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class BooksFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View rootView;

    public BooksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView =  inflater.inflate(R.layout.fragment_books, container, false);


        String[] myDataset = new String[]{"Java" , "Scala" , "Groovy"};

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.book_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BooksAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}
