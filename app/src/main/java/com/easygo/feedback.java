package com.easygo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class feedback extends AppCompatActivity {
    private EditText e1;
    Button button;
    Spinner spinner,spinner1;
    FirebaseAuth fauth;
    DatabaseReference mDatabase;
    StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        fauth = FirebaseAuth.getInstance();
        button =(Button)findViewById(R.id.button3);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner1=(Spinner)findViewById(R.id.spinner2);
        e1=(EditText)findViewById(R.id.editText);


        addSpinnerItem();
        add1SpinnerItem();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm())
                {
                    String items =e1.getText().toString().trim();



                    // create user object and set all the properties
                   feedbackpojo user=new feedbackpojo();
                    user.setComment(items);

                    if(fauth.getCurrentUser()!=null)
                    {
                        // save the user at UserNode under user UID
                        mDatabase.child("FEEDBACK").child(fauth.getCurrentUser().getUid()).setValue(user, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                if(databaseError==null)
                                {
                                    Toast.makeText(feedback.this, "feedback is successfullr submitted..we will contact you soon",
                                            Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        });
                    }
                }
            }
        });


    }
    public boolean validateForm()
    {
        boolean alldone=true;
        String items=e1.getText().toString().trim();

        if(TextUtils.isEmpty(items))
        {
            e1.setError("item lost or found");
            return false;
        }else
        {
            alldone=true;
            e1.setError(null);
        }

        return alldone;
    }
    private void add1SpinnerItem() {

        String[] platforms=getResources().getStringArray(R.array.catogory);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,platforms);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView) view;
               // m_tv.setText(tv.getText());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void addSpinnerItem() {

        String[] platforms=getResources().getStringArray(R.array.feedback);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,platforms);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView) view;
                //m_tv.setText(tv.getText());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
