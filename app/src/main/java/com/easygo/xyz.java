package com.easygo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Application;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class xyz extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private FirebaseAuth .AuthStateListener mauthlistener;
    private FirebaseAuth mAuth;
    private GoogleApiClient mGoogleApiClient;
    private String TAG="xyz";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText fname,lname,age,email;
        Button save;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xyz);
        b1=(Button)findViewById(R.id.button4);
        mAuth=FirebaseAuth.getInstance();
        //mauthlistener = new FirebaseAuth.AuthStateListener() {
        /*    @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                   startActivity(new Intent(xyz.this,MainActivity1.class));
                }

            }
        }; */

        b2=(Button)findViewById(R.id.button5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOu();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();

            }


            private void signOut() {
                    mAuth.signOut();

                    // Google sign out
                    Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                            new ResultCallback<Status>() {
                                @Override
                                public void onResult(@NonNull Status status) {
                                    Log.d(TAG, "signOut:onResult:" + status);
                                    startActivity(new Intent(xyz.this,signup.class));
                                }
                            });
            }


    });


}

    private void signOu() {
        startActivity(new Intent(xyz.this,login.class));
        finish();
    }

    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this,new GoogleApiClient.OnConnectionFailedListener(){
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(xyz.this,"error",Toast.LENGTH_LONG).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();

    }


}
