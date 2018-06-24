package com.marvedie.ecitizenhudumakenya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button buttonEcitizen;
    private Button buttonEcitizenGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() ==null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome"+ user.getEmail());
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonEcitizen = (Button) findViewById(R.id.buttonEcitizen);
        buttonEcitizenGuide = (Button) findViewById(R.id.buttonEcitizenGuide);

        buttonLogout.setOnClickListener(this);
        buttonEcitizen.setOnClickListener(this);
        buttonEcitizenGuide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (view == buttonEcitizen) {
            finish();
            startActivity(new Intent(this, EcitizenLogin.class));
        }
            if (view == buttonEcitizenGuide){
                finish();
                startActivity(new Intent(this, EcitizenGuide.class));
            }
        }

    }

