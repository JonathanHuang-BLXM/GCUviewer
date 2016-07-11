package com.ashez.garfield.gcuviewer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashez.garfield.gcuviewer.R;
import com.ashez.garfield.gcuviewer.activity.SecondaryCatalogueActivity;
import com.ashez.garfield.gcuviewer.activity.WebActivity;

/**
 * Created by Garfield on 16/7/10.
 */
public class ContentRVAdapter extends RecyclerView.Adapter<ContentRVAdapter.MyHolder> {

    private String[] contentTitle;
    private String[] contentAuthor;
    private Context context;
//    private String[] contentBackgoundLink;

    public ContentRVAdapter(String[] contentTitle, String[] contentAuthor, Context context) {
        this.contentTitle = contentTitle;
        this.contentAuthor = contentAuthor;
        this.context = context;
        //this.contentBackgoundLink = contentBackgoundLink;//,String[] contentBackgoundLink
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_secondary_catalogue, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView4title.setText(contentTitle[position]);
        holder.textView4author.setText(contentAuthor[position]);
        holder.imageView4bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("website", "http://zs.gcu.edu.cn/");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contentTitle.length;
    }
    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView4bg;
        TextView textView4title;
        TextView textView4author;
        public MyHolder(View itemView) {
            super(itemView);
            imageView4bg = (ImageView) itemView.findViewById(R.id.content_catalogue_bg);
            textView4author = (TextView) itemView.findViewById(R.id.content_catalogue_author);
            textView4title = (TextView) itemView.findViewById(R.id.content_catalogue_title);
        }
    }
}
