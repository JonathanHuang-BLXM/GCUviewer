package com.ashez.garfield.gcuviewer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Garfield on 16/7/10.
 */
public class ContentRVAdapter extends RecyclerView.Adapter<ContentRVAdapter.MyHolder> {

    private String[] contentTitle;
    private String[] contentAuthor;
//    private String[] contentBackgoundLink;

    public ContentRVAdapter(String[] contentTitle,String[] contentAuthor) {
        this.contentTitle = contentTitle;
        this.contentAuthor = contentAuthor;
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
