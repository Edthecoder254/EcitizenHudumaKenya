package com.marvedie.ecitizenhudumakenya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EcitizenLogin extends AppCompatActivity{
    //view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView tvForgotPassword;
    private TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecitizen_login);


        //Initialise objects
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        tvCreateAccount = (TextView) findViewById(R.id.tvCreateAccount);
    }

}

