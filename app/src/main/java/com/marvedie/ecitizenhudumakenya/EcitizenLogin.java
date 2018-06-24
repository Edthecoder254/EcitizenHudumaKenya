package com.marvedie.ecitizenhudumakenya;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EcitizenLogin extends AppCompatActivity implements View.OnClickListener {
    //view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView tvForgotPassword;
    private TextView tvCreateAccount;

    private ProgressDialog progressDialog;

    //firebase authentication object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecitizen_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //start profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        //Initialise objects
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        tvCreateAccount = (TextView) findViewById(R.id.tvCreateAccount);

        buttonLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        //if validation is okay we will show progress bar here because it is an internet activity
        //taking time

        progressDialog.setMessage("Please Wait as we log you into the system");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), EcitizenDashboard.class));
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        if (view == buttonLogin) {
            userLogin();
        }
        if (view == tvCreateAccount) {
            finish();
            startActivity(new Intent(this,  RegisterEcitizen.class));
        }
        if (view == tvForgotPassword) {
            finish();
            startActivity(new Intent(this, ForgotPassword.class));
        }

    }
}

