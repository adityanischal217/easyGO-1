package com.easygo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Response extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);
        Toast.makeText(Response.this,"WE HAVE RECEIVED YOUR MESSAGE.YOU WILL BE ASSISTED SOON",Toast.LENGTH_LONG).show();
        //Intent intent=new Intent(Response.this,MainActivity.class);
        //startActivity(intent);
    }
}
