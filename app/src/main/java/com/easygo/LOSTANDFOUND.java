package com.easygo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class LOSTANDFOUND extends AppCompatActivity {
    TextView final_result;
    TextView name;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostandfound);
        final_result=(TextView)findViewById(R.id.text2);
        name=(TextView)findViewById(R.id.edit);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      Toast.makeText(LOSTANDFOUND.this,"Sent",Toast.LENGTH_LONG).show();

                                  }
                              });
                final_result.setEnabled(false);
    }
        public void Selectchoice (View view)
    {
        boolean checked =((RadioButton) view).isChecked();

        switch(view.getId()) {

            case R.id.radioButton3:
                if (checked) {
                    final_result.setText("you selected the lost option");
                    final_result.setEnabled(true);
                    final_result.setText("Name the item you have lost");
                    name.getEditableText();
                } else {
                    final_result.setEnabled(false);
                }
                break;


            case R.id.radioButton6:
                if (checked) {
                    final_result.setText("you selected the found option");
                    final_result.setText("Name the item you have found");
                    name.getEditableText();
                    final_result.setEnabled(true);
                }
                else {
                    final_result.setEnabled(false);
                }
                break;
        }

    }




    }



