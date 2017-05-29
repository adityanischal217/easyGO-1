package com.easygo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class avfacility extends AppCompatActivity {
 Button B1,B2,B3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avfacility);
        B1=(Button)findViewById(R.id.button6);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(avfacility.this,atmmap.class);

startActivity(intent);
                finish();
            }
        });
        B2=(Button)findViewById(R.id.button16);
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(avfacility.this,CABMAP.class);

                startActivity(intent);
                finish();
            }
        });
        B3=(Button)findViewById(R.id.button11);
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(avfacility.this,MEDICALMAP.class);

                startActivity(intent);
                finish();
            }
        });

    }
}
