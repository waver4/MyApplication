package com.waver.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {
    private List<Category> mdata;
    private RecyclerView mrecyclerView;
    private CatAdapter myAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mdata = new ArrayList<>();
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
        mdata.add(new Category(getString(R.string.app_name),R.mipmap.ic_launcher));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        mrecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        final FragmentActivity fragmentActivity = getActivity();

        mrecyclerView.setLayoutManager(new GridLayoutManager(fragmentActivity, 2));
        mrecyclerView.setHasFixedSize(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                myAdapter = new CatAdapter(fragmentActivity, mdata);
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
