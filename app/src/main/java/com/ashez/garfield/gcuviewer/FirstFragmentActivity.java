package com.ashez.garfield.gcuviewer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class FirstFragmentActivity extends android.support.v4.app.FragmentActivity {

    ViewPager viewPager;
    List<Fragment> fragmentList;
    FirstFragment oneFragment;
    SecondFragment twoFragment;
    FragmentAdapter mAdapter;
    FragmentManager mManager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstfragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        getActionBar().setDisplayShowHomeEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tab_FindFragment_title) ;
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentList = new ArrayList<Fragment>();
        oneFragment = new FirstFragment();
        twoFragment = new SecondFragment();
        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        mAdapter = new FragmentAdapter(this.getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
