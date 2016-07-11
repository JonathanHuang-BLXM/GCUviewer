package com.ashez.garfield.gcuviewer.javabean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Garfield on 16/7/11.
 */
public class Kind extends BmobObject {
    private String kind;
    private String sub_kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSub_kind() {
        return sub_kind;
    }

    public void setSub_kind(String sub_kind) {
        this.sub_kind = sub_kind;
    }
}
