package com.waver.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
        View view = mLayoutInflater.inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mdata.get(position).getNews_title());
        holder.imageView.setImageResource(mdata.get(position).getNews_icon());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.base_swipe_item_title);
            imageView = (ImageView) itemView.findViewById(R.id.base_swipe_item_icon);
            cardView = (CardView) itemView.findViewById(R.id.card_view);


        }
    }


}