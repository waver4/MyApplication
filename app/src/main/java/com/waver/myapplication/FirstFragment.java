package com.waver.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    protected List<CardNews> mdata;
    private RecyclerView mrecyclerView;
    private MyAdapter myAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    private void initDataset() {

        mdata = new ArrayList<>();
        mdata.add(new CardNews(getString(R.string.news_one_title), getString(R.string.news_one_desc), R.mipmap.ic_launcher));
        mdata.add(new CardNews(getString(R.string.news_two_title), getString(R.string.news_two_desc), R.mipmap.ic_launcher));
        mdata.add(new CardNews(getString(R.string.news_three_title), getString(R.string.news_three_desc), R.mipmap.ic_launcher));
        mdata.add(new CardNews(getString(R.string.news_four_title), getString(R.string.news_four_desc), R.mipmap.ic_launcher));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        mrecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        final FragmentActivity fragmentActivity = getActivity();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragmentActivity, LinearLayoutManager.VERTICAL, false);
        mrecyclerView.setLayoutManager(linearLayoutManager);
        new Thread(new Runnable() {
            @Override
            public void run() {
                myAdapter = new MyAdapter(fragmentActivity, mdata);
                fragmentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mrecyclerView.setAdapter(myAdapter);
                    }
                });
            }
        }).start();


        return rootView;

    }
}
