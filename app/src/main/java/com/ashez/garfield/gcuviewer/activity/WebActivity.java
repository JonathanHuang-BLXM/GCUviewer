package com.ashez.garfield.gcuviewer.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ashez.garfield.gcuviewer.R;
/**
 * @author 菠萝小莫
 *         Contact: Jonathan.expine@gmail.com
 *         date: 2016-07-11
 */
public class WebActivity extends AppCompatActivity {
    private WebView webView;
    private String url;
    private Intent intent;
    private String name;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        name = getIntent().getStringExtra("name");
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);

        initData();
        initViews(toolbar);
        //FAB();
    }

    private void initData() {
        url = getIntent().getStringExtra("website");
    }

    private void initViews(Toolbar toolbar) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        assert toolbar != null;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        webView = (WebView) findViewById(R.id.webview);
        if (webView != null) {
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}
