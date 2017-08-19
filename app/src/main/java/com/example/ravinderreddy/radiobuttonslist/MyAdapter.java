package com.example.ravinderreddy.radiobuttonslist;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RadioButton;

import java.util.List;

/**
 * Created by Ravinder Reddy on 19-08-2017.
 */

public class MyAdapter implements ListAdapter {
    private List<Model> mModelList = null;
    private Context mContext;
    private LayoutInflater mInflater;
    public MyAdapter(List<Model> mModelList, Context mContext) {
        this.mModelList = mModelList;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return mModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return mModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         view  = mInflater.inflate(R.layout.simple_layout,null);
        RadioButton textView = view.findViewById(R.id.textView);
        textView.setText(mModelList.get(i).getName());
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
