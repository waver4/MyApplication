package com.waver.myapplication;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mtoolbar;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<CardNews> mdata;
    private NavigationView mnavigationview;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mdrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        initInstances();
        initRecyclerView();
        initNavigationView();


    }

    private void findView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mtoolbar = (Toolbar) findViewById(R.id.tool_bar);
        mnavigationview = (NavigationView) findViewById(R.id.navigationView);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initRecyclerView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        mdata = new ArrayList<>();
        mdata.add(new CardNews(getString(R.string.news_one_title), getString(R.string.news_one_desc), R.drawable.view01));
        mdata.add(new CardNews(getString(R.string.news_two_title), getString(R.string.news_two_desc), R.drawable.view02));
        mdata.add(new CardNews(getString(R.string.news_three_title), getString(R.string.news_three_desc), R.drawable.view03));
        mdata.add(new CardNews(getString(R.string.news_four_title), getString(R.string.news_four_desc), R.drawable.view04));

        mMyAdapter = new MyAdapter(this, mdata);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mMyAdapter);
    }


    //使用toolbar
    private void initInstances() {

        setSupportActionBar(mtoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mtoolbar.setTitle("优惠");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建返回键，并实现开/关监听
        mdrawerToggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);
        mdrawerToggle.syncState();
        mdrawerLayout.setDrawerListener(mdrawerToggle);
        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        Toast.makeText(MainActivity
                                .this, "查找按钮", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity
                                .this, "分享按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    //    侧滑菜单
    private void initNavigationView() {


        //设置侧滑菜单选择监听事件
        mnavigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                //关闭抽屉侧滑菜单
                mdrawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.navItem2:
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                        break;

                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (mdrawerToggle.onOptionsItemSelected(item))
            return true;


        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
