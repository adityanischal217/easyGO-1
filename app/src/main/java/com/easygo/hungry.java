package com.easygo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class hungry extends AppCompatActivity {
    Button b1,b2,b3,b5,b6,b7,b8;
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungry);

        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button9);
        b3=(Button)findViewById(R.id.button10);
        b5=(Button)findViewById(R.id.button12);
        b6=(Button)findViewById(R.id.button13);
        b7=(Button)findViewById(R.id.button14);
        b8=(Button)findViewById(R.id.button15);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Uri uri = Uri.parse("http://www.thebelgianfriesco.com/");
              //  Intent intent = new Intent(Intent.ACTION_VIEW, uri);
              //  startActivity(intent);
                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="http://www.thebelgianfriesco.com/";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());
            }
            class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://online.pizzahut.co.in/";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());

                //   Uri uri = Uri.parse("https://online.pizzahut.co.in/");

              //  Intent intent = new Intent(Intent.ACTION_VIEW, uri);
              //  startActivity(intent);
            }
             class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://www.krispykrunchy.com/";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());


            }
            class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://www.dominos.co.in";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());
            }   class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            } });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://www.mcdelivery.co.in/";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());
            }
            class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://www.keventers.co.in";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());
            }
            class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://www.madoverdonuts.com/";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());
            }
            class MyBrowser extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });
    }

}

