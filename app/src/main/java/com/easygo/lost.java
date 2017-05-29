package com.easygo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.easygo.R.id.fname;

public class lost extends AppCompatActivity {
    EditText e1;
    EditText e2,e3,e4;

    Button B1;


    FirebaseAuth fauth;
    DatabaseReference mDatabase;
    StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        fauth = FirebaseAuth.getInstance();

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText11);
        e4 = (EditText)findViewById(R.id.editText12);

        B1 = (Button)findViewById(R.id.button18);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm())
                {
                    String items =e1.getText().toString().trim();
                    String description =e2.getText().toString().trim();
                    String weight =e3.getText().toString().trim();
                    String colour =e4.getText().toString().trim();


                    // create user object and set all the properties
                    Person user=new Person();
                    user.setItems(items);
                    user.setDescription(description);
                    user.setColour(colour);
                    user.setWeight(weight);
                    if(fauth.getCurrentUser()!=null)
                    {
                        // save the user at UserNode under user UID
                      mDatabase.child("LOST AND FOUND").child(fauth.getCurrentUser().getUid()).setValue(user, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                if(databaseError==null)
                                {
                                    Toast.makeText(lost.this, "Data is saved successfully",
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
        String description=e2.getText().toString().trim();
        String weight =e3.getText().toString().trim();
        String colour =e4.getText().toString().trim();
        if(TextUtils.isEmpty(items))
        {
            e1.setError("item lost or found");
            return false;
        }else
        {
            alldone=true;
            e1.setError(null);
        }
        if(TextUtils.isEmpty(description))
        {
            e2.setError("description");
            return false;
        }else
        {
            alldone=true;
            e2.setError(null);
        }
        if(TextUtils.isEmpty(weight))
        {
            e3.setError("weight");
            return false;
        }else
        {
            alldone=true;
            e3.setError(null);
        }
        if(TextUtils.isEmpty(colour))
        {
            e4.setError("colors");
            return false;
        }else
        {
            alldone=true;
            e4.setError(null);
        }
        return alldone;
    }







    }



