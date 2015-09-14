package com.waver.myapplication;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private Toolbar mtoolbar;
    private TabLayout mtabs;
    private NavigationView mnavigationview;
    private DrawerLayout mdrawerLayout;
    private ViewPager mviewpager;
    private MyFragmentPagerAdapter madapter;
    private List<Fragment> mfragments;
    private RecyclerView mrecyclerView;
    List<String> mdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initTabs();
        initNavigationView();

    }


    //    侧滑菜单
    private void initNavigationView() {

        mnavigationview = (NavigationView) findViewById(R.id.navigationView);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //设置侧滑菜单选择监听事件
        mnavigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                //关闭抽屉侧滑菜单
                mdrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    //使用Tabs
    private void initTabs() {
        mviewpager = (ViewPager) findViewById(R.id.viewpager);

        mtabs = (TabLayout) findViewById(R.id.tab_layout);

        mfragments = new ArrayList<>();
        FirstFragment tab1 = new FirstFragment();
        SecondFragment tab2 = new SecondFragment();
        ThirdFragment tab3 = new ThirdFragment();
        mfragments.add(tab1);
        mfragments.add(tab2);
        mfragments.add(tab3);

        madapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mfragments);
        mviewpager.setAdapter(madapter);
        mtabs.setupWithViewPager(mviewpager);
    }

    //使用toolbar
    private void initToolBar() {

        mtoolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mtoolbar);

        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        Toast.makeText(SecondActivity
                                .this, "查找按钮", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(SecondActivity
                                .this, "分享按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home) {
            //打开抽屉侧滑菜单
            mdrawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }
}
