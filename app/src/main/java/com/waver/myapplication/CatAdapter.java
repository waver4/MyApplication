package com.waver.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.MyViewHolder> {
    private List<Category> mdata;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CatAdapter(Context context, List<Category> myDataset) {
        mdata = myDataset;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.category, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        final int j = i;
        myViewHolder.news_photo.setImageResource(mdata.get(i).getPhotoId());
        myViewHolder.news_title.setText(mdata.get(i).getTitle());

        //为cardView设置点击事件
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebActivity.class);
                intent.putExtra("web", mdata.get(j));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView news_photo;
        TextView news_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cat_cardview);
            news_photo = (ImageView) itemView.findViewById(R.id.cat_img);
            news_title = (TextView) itemView.findViewById(R.id.cat_text);
            //设置TextView背景为半透明
            news_title.setBackgroundColor(Color.argb(20, 0, 0, 0));


        }
    }

}