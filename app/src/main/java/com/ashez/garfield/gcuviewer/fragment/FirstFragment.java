package com.ashez.garfield.gcuviewer.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashez.garfield.gcuviewer.R;
import com.ashez.garfield.gcuviewer.activity.SecondaryCatalogueActivity;
import com.ashez.garfield.gcuviewer.activity.WebActivity;
import com.ashez.garfield.gcuviewer.activity.IntroductionActivity;
import com.ashez.garfield.gcuviewer.activity.SecondaryCatalogueActivity;
import com.ashez.garfield.gcuviewer.activity.StudentActivity;
import com.ashez.garfield.gcuviewer.activity.SystemActivity;

/**
 * Created by 武纪怡 on 2016/7/10.
 */
public class FirstFragment extends Fragment {

    private Context context;
    private String[] mtitle;

    public FirstFragment(){}


    @SuppressLint("ValidFragment")
    public FirstFragment(Context context) {
        this.context = context;
    }

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        final View chatView = inflater.inflate(R.layout.activity_first, container,false);

        chatView.findViewById(R.id.button_introduction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("website", "http://baike.baidu.com/link?url=iPKXYXIJRuWQ_5gSXQpWtYuuKDDBonrBU9BF3btuAGkzi-ROdaHxS9LKf4xcN3_2puZxylnBEmNotr2Q2kHdU_");
                intent.putExtra("name",getResources().getString(R.string.introduction));
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("website", "http://zs.gcu.edu.cn/");
                intent.putExtra("name",getResources().getString(R.string.student));
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_system).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,WebActivity.class);
                intent.putExtra("website","http://jwxt.gcu.edu.cn/");
                intent.putExtra("name",getResources().getString(R.string.system));
                context.startActivity(intent);

            }
        });

        chatView.findViewById(R.id.button_tissue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondaryCatalogueActivity.class);
                intent.putExtra("name",getResources().getString(R.string.tissue));
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_organization).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondaryCatalogueActivity.class);
                intent.putExtra("name",getResources().getString(R.string.organization));
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondaryCatalogueActivity.class);
                intent.putExtra("name",getResources().getString(R.string.second));
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_orgs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SecondaryCatalogueActivity.class);
                intent.putExtra("kinds", "orgs");
                startActivity(intent);
            }
        });

        return chatView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

}
