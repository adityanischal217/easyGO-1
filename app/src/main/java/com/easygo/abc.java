package com.easygo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by coderzpassion on 31/07/16.
 */
public class abc extends AppCompatActivity {
    EditText fname,lname,age,email;
    Button save;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_xml);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        age=(EditText)findViewById(R.id.age);
        email=(EditText)findViewById(R.id.email);
        save=(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm())
                {
                    String frstname=fname.getText().toString().trim();
                    String lstname=lname.getText().toString().trim();
                    String ae=age.getText().toString().trim();
                    String ema=email.getText().toString().trim();
                    // create user object and set all the properties
                    Person user=new Person();
              /*      user.setFirstname(frstname);
                    user.setLastname(lstname);
                    user.setAge(ae);
                    user.setEmail(ema);
                */    if(mAuth.getCurrentUser()!=null)
                    {
                        // save the user at UserNode under user UID
                        mDatabase.child("UserNode").child(mAuth.getCurrentUser().getUid()).setValue(user, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                if(databaseError==null)
                                {
                                    Toast.makeText(abc.this, "Data is saved successfully",
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
    // to check if user filled all the required fieds
    public boolean validateForm()
    {
        boolean alldone=true;
        String frstname=fname.getText().toString().trim();
        String lstname=lname.getText().toString().trim();
        String ae=age.getText().toString().trim();
        String ema=email.getText().toString().trim();
        if(TextUtils.isEmpty(frstname))
        {
            fname.setError("Enter your first name");
            return false;
        }else
        {
            alldone=true;
            fname.setError(null);
        }
        if(TextUtils.isEmpty(lstname))
        {
            lname.setError("Enter your last name");
            return false;
        }else
        {
            alldone=true;
            lname.setError(null);
        }
        if(TextUtils.isEmpty(ae))
        {
            age.setError("Enter your Age");
            return false;
        }else
        {
            alldone=true;
            age.setError(null);
        }
        if(TextUtils.isEmpty(ema))
        {
            email.setError("Enter your Email");
            return false;
        }else
        {
            alldone=true;
            email.setError(null);
        }
        return alldone;
    }
}