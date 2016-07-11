package com.ashez.garfield.gcuviewer.network;

import android.content.Context;

import com.ashez.garfield.gcuviewer.javabean.Kind;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Garfield on 16/7/11.
 */
public class GetLink {
    public static List mList;
    public List getkind(String subKind, Context context){
        mList=null;
        BmobQuery<Kind> query = new BmobQuery<>();
        query.addWhereEqualTo("sub_kind", "校级组织");
        query.findObjects(context, new FindListener<Kind>() {
            @Override
            public void onSuccess(List<Kind> list) {
                mList = list;
            }

            @Override
            public void onError(int i, String s) {
                System.out.println("出现错误" + i + "string.." + s);
            }
        });
        return mList;
    }

}
