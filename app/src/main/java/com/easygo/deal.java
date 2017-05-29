package com.easygo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class deal extends AppCompatActivity {

    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        b1 =(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intent=new Intent(deal.this,hungry.class);
                startActivity(intent);

            }
        });
        b2 =(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {

                Intent intent=new Intent(deal.this,shopping.class);
                startActivity(intent);


            }

        });
    }
    }

