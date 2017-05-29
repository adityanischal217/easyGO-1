package com.easygo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class shopping extends AppCompatActivity {
    Button b1,b2,b3;
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);


        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button9);
        b3=(Button)findViewById(R.id.button10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="https://www.bigbazaar.com/";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
                String  url="http://www.armani.com/us/armanicollezioni";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.livestatus);
                wv1=(WebView)findViewById(R.id.webview);
               // String  url="https:/www.giniandjony.com/";
                String  url="https://www.giniandjony.com";
                wv1.loadUrl(url);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new livestatus.MyBrowser());


            }
        });



    }
}
