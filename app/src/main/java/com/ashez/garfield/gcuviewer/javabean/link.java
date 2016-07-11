package com.ashez.garfield.gcuviewer.javabean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Garfield on 16/7/11.
 */
public class Link extends BmobObject {
    private String website_content;
    private String website_pic;
    private String title;
    private String kind;

    public String getWebsite_content() {
        return website_content;
    }

    public void setWebsite_content(String website_content) {
        this.website_content = website_content;
    }

    public String getWebsite_pic() {
        return website_pic;
    }

    public void setWebsite_pic(String website_pic) {
        this.website_pic = website_pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
