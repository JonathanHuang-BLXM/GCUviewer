package com.ashez.garfield.gcuviewer.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ashez.garfield.gcuviewer.R;
import com.ashez.garfield.gcuviewer.activity.AboutActivity;
import com.ashez.garfield.gcuviewer.activity.SecondaryCatalogueActivity;

/**
 * Created by 武纪怡 on 2016/7/10.
 */

public class SecondFragment extends Fragment {

    private Context context;

    public SecondFragment(Context context) {
        this.context = context;
    }
    public SecondFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View chatView = inflater.inflate(R.layout.activity_second, container,false);


        chatView.findViewById(R.id.button_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AboutActivity.class);
                intent.putExtra("name",getResources().getString(R.string.about));
                System.out.print("ssssssss");
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
