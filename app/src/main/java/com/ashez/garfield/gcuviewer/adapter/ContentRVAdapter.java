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
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @author 菠萝小莫
 *         Contact: Jonathan.expine@gmail.com
 *         date: 2016-07-11
 */
public class ContentRVAdapter extends RecyclerView.Adapter<ContentRVAdapter.MyHolder> {

    /**
     * 正文标题
     * */
    private ArrayList<String> contentTitle;
    /**
     * 作者信息
     * */
    private ArrayList<String> contentAuthor;
    /**
     * 文章标题背景图片
     * */
    private ArrayList<String> contentPicture;

    private ArrayList<String> contentWebsite;

    private Context context;

    public ContentRVAdapter(ArrayList<String> contentTitle, ArrayList<String> contentAuthor,
                            ArrayList<String>contentPicture,ArrayList<String> contentWebsite, Context context) {
        this.contentTitle = contentTitle;
        this.contentAuthor = contentAuthor;
        this.context = context;
        this.contentPicture = contentPicture;
        this.contentWebsite = contentWebsite;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_secondary_catalogue, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.textView4title.setText(contentTitle.get(position));
        holder.textView4author.setText(contentAuthor.get(position));
        holder.imageView4bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("website", contentWebsite.get(position));
                context.startActivity(intent);
            }
        });
        Glide.with(holder.imageView4bg.getContext())

                .load(contentPicture.get(position))

//                .error(R.drawable.ic_person)//load失敗的Drawable

                .placeholder(R.mipmap.logo)//loading時候的Drawable

//                .animate()//設置load完的動畫

//                .centerCrop()//中心切圖, 會填滿

                .fitCenter()//中心fit, 以原本圖片的長寬為主

                .into(holder.imageView4bg);
    }

    @Override
    public int getItemCount() {
        return contentTitle.size();
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
