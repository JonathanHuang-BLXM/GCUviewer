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
import com.ashez.garfield.gcuviewer.activity.IntroductionActivity;
import com.ashez.garfield.gcuviewer.activity.StudentActivity;
import com.ashez.garfield.gcuviewer.activity.SystemActivity;

/**
 * Created by 武纪怡 on 2016/7/10.
 */
public class FirstFragment extends Fragment {

    private Context context;


    public FirstFragment(){}


    @SuppressLint("ValidFragment")
    public FirstFragment(Context context) {
        this.context = context;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View chatView = inflater.inflate(R.layout.activity_first, container,false);

        chatView.findViewById(R.id.button_introduction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,IntroductionActivity.class);
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,StudentActivity.class);
                context.startActivity(intent);
            }
        });

        chatView.findViewById(R.id.button_system).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SystemActivity.class);
                context.startActivity(intent);
            }
        });

        return chatView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

}
