package com.easygo;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by Cnf on 8/3/2016.
 */
public class login extends AppCompatActivity{

    EditText e1;
    EditText e2;
    Button b1;

    ProgressDialog progressdialog;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

            e1 = (EditText) findViewById(R.id.editText6);
            e2 = (EditText) findViewById(R.id.editText7);
            b1 = (Button) findViewById(R.id.button3);


            firebaseAuth = FirebaseAuth.getInstance();
            databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
            FirebaseUser user = firebaseAuth.getCurrentUser();


            progressdialog = new ProgressDialog(this);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StartLogin();

                }
            });
        }

        private void StartLogin() {

            String email= e1.getText().toString().trim();
            String password= e2.getText().toString().trim();

            if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password)){

                progressdialog.setMessage("loading....");
                progressdialog.show();

                firebaseAuth.signInWithEmailAndPassword(email,password ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            checkUserExit();

                        }else

                        {
                            Toast.makeText(login.this,"login error",Toast.LENGTH_LONG).show();
                            progressdialog.dismiss();

                        }


                    }

                    private void checkUserExit() {

                        final String userid = firebaseAuth.getCurrentUser().getUid();

                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(userid)){

                                    Intent intent = new Intent(login.this, xyz.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });





                    }
                });





            }



        }



    }