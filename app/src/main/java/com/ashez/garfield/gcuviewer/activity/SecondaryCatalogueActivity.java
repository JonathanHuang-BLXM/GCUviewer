package com.ashez.garfield.gcuviewer.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.ashez.garfield.gcuviewer.adapter.ContentRVAdapter;
import com.ashez.garfield.gcuviewer.R;
import com.ashez.garfield.gcuviewer.javabean.Kind;
import com.ashez.garfield.gcuviewer.javabean.Link;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * @author 菠萝小莫
 *         Contact: Jonathan.expine@gmail.com
 *         date: 2016-07-10
 */
public class SecondaryCatalogueActivity extends AppCompatActivity {

    private int                            pos;
    private String                         sub_kind;

    private String[]                       mContentTitle;
    private String[]                       mContentPicture;
    private String[]                       mContentWebsite;
    private String[]                       mContentAuthor;
    private String[]                       mTabTitle = {"?", "?"};

    private ViewPager                      mViewPager;
    private TabLayout                      mTabLayout;
    private TabLayout.Tab[]                mTabs;

    private SectionsPagerAdapter           mSectionsPagerAdapter;
    private List<PlaceholderFragment>      mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_catalogue);
        init();
    }

    private void init() {
        mFragments = new ArrayList<>();

        switch (getIntent().getStringExtra("kinds")) {
            case "orgs":
                sub_kind = "校级组织";
                break;
            case "college":
                sub_kind = "二级学院";
        }
        BmobQuery<Kind> query = new BmobQuery<>();
        query.addWhereEqualTo("sub_kind", sub_kind);
        query.findObjects(this, new FindListener<Kind>() {
            @Override
            public void onSuccess(List<Kind> list) {
                mTabTitle = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    mTabTitle[i] = list.get(i).getKind();
                }
                initViews();
                getLink(0);
            }

            @Override
            public void onError(int i, String s) {
                System.out.println("出现错误" + i + "string.." + s);
            }
        });
        System.out.println("第一个title是....." + mTabTitle[0]);
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(sub_kind);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });//返回键
        // 用SectionsPagerAdapter绑定vp和fragment，
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), mFragments);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //监听页面变化，当前选中的fragment联网加载
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                pos = position;
                getLink(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabs = new TabLayout.Tab[mTabTitle.length];
        for (int i = 0; i < mTabTitle.length; i++) {
            //Initialize every tab
            mTabs[i] = mTabLayout.getTabAt(i);
//            mTabs[i].setIcon(R.drawable.ic_face_black_24dp);
        }
    }

    private void getLink(int position) {
        BmobQuery<Link> query = new BmobQuery<>();
        query.addWhereEqualTo("kind", mTabTitle[position]);
        query.findObjects(getBaseContext(), new FindListener<Link>() {
            @Override
            public void onSuccess(List<Link> list) {
                System.out.println("数组大小" + list.size());
                mContentTitle = new String[list.size()];
                mContentAuthor = new String[list.size()];
                mContentPicture = new String[list.size()];
                mContentWebsite = new String[list.size()];

                for (int i = 0; i < list.size(); i++) {
                    mContentTitle[i] = list.get(i).getTitle();
                    mContentAuthor[i] = "菠萝小莫";
                    mContentPicture[i] = list.get(i).getWebsite_pic();
                    mContentWebsite[i] = list.get(i).getWebsite_content();
                }
                mFragments.get(pos).notifyDataChanges(mContentTitle, mContentAuthor, mContentPicture, mContentWebsite);
            }
            @Override
            public void onError(int i, String s) {
                System.out.println("出现错误" + i + "string.." + s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_secondary_catalogue, menu);
        return true;
    }

    /**
     * 自定义Fragment
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * ARG_SECTION_NUMBER:第几个fragment标记
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private RecyclerView mRecyclerView;
        private ContentRVAdapter mAdapter;
        private ArrayList<String> mContentTitle = new ArrayList<>();
        private ArrayList<String> mContentAuthor = new ArrayList<>();
        private ArrayList<String> mContentPicture = new ArrayList<>();
        private ArrayList<String> mContentWebsite = new ArrayList<>();

        public PlaceholderFragment() {
        }

        /**
         * 返回第sectionNumber个fragment
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_secondary_catalogue, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

            return rootView;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
            mRecyclerView.setHasFixedSize(true);


            mAdapter = new ContentRVAdapter(mContentTitle, mContentAuthor, mContentPicture, mContentWebsite, getContext());
            mRecyclerView.setAdapter(mAdapter);

        }

        public void notifyDataChanges(String[] mContentTitle, String[] mContentAuthor, String[] mContentPicture, String[] mContentWebsite) {

            this.mContentTitle.clear();
            this.mContentAuthor.clear();
            this.mContentPicture.clear();
            this.mContentWebsite.clear();


            for (int i = 0; i < mContentTitle.length; i++) {
                this.mContentTitle.add(mContentTitle[i]);
                this.mContentAuthor.add(mContentAuthor[i]);
                this.mContentPicture.add(mContentPicture[i]);
                this.mContentWebsite.add(mContentWebsite[i]);
            }


            mAdapter.notifyDataSetChanged();
            System.out.println("执行到了...........");
        }


    }

    /**
     * 二级菜单ViewPager的Adapter
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        List<PlaceholderFragment> mFragments;

        public SectionsPagerAdapter(FragmentManager fm, List<PlaceholderFragment> list) {
            super(fm);
            this.mFragments = list;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            PlaceholderFragment fragment = PlaceholderFragment.newInstance(position + 1);
            mFragments.add(fragment);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show total array size pages.
            return mTabTitle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitle[position];
        }


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

        return super.onOptionsItemSelected(item);
    }
}
