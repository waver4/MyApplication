package com.waver.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<CardNews> mdata;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, List<CardNews> myDataset) {
        mdata = myDataset;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mdata.get(position).getNews_title());
        holder.imageView.setImageResource(mdata.get(position).getNews_icon());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.base_swipe_item_title);
            imageView = (ImageView) itemView.findViewById(R.id.base_swipe_item_icon);


        }
    }




}