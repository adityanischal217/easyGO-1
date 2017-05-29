package com.easygo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class hotels extends AppCompatActivity {
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);


        wv1=(WebView)findViewById(R.id.webview);
        String  url="https://www.makemytrip.com/";
        wv1.loadUrl(url);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setWebViewClient(new hotels.MyBrowser());

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
