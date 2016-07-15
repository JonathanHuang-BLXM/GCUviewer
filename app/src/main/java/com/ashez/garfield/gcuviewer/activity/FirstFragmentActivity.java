package com.ashez.garfield.gcuviewer.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.ashez.garfield.gcuviewer.Contants;
import com.ashez.garfield.gcuviewer.fragment.FirstFragment;
import com.ashez.garfield.gcuviewer.adapter.FragmentAdapter;
import com.ashez.garfield.gcuviewer.R;
import com.ashez.garfield.gcuviewer.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.a.I;

/**
 * Created by 武纪怡 on 2016/7/10.
 */

public class FirstFragmentActivity extends android.support.v4.app.FragmentActivity {

    ViewPager viewPager;
    List<Fragment> fragmentList;
    FirstFragment oneFragment;
    SecondFragment twoFragment;
    FragmentAdapter mAdapter;
    TabLayout tabLayout;
    ImageView imageView;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstfragment);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        getActionBar().setDisplayShowHomeEnabled(false);

//        tabLayout = (TabLayout) findViewById(R.id.tab_FindFragment_title) ;
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentList = new ArrayList<Fragment>();
        oneFragment = new FirstFragment(this);
        twoFragment = new SecondFragment(this);
        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);

        imageView = (ImageView) findViewById(R.id.dot);
        imageView1 = (ImageView) findViewById(R.id.dot1);
        imageView.setEnabled(true);
        imageView1.setEnabled(false);

//        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        mAdapter = new FragmentAdapter(this.getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(mAdapter);
//        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        imageView.setEnabled(true);
                        imageView1.setEnabled(false);
                        break;
                    case 1:
                        imageView.setEnabled(false);
                        imageView1.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        initBmob();
    }

    private void initBmob() {
        Bmob.initialize(this, Contants.BMOB_KEY);
    }
}
