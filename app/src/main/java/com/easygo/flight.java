package com.easygo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import static com.easygo.R.id.webview;

public class flight extends AppCompatActivity {

WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.booknow);



            wv1=(WebView)findViewById(R.id.webview);
      String  url="https://www.makemytrip.com/flight";
        wv1.loadUrl(url);
        wv1.getSettings().setJavaScriptEnabled(true);
            wv1.setWebViewClient(new MyBrowser());


        }

         static class MyBrowser extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }
    }


