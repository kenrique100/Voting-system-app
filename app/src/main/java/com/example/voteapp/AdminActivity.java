package com.example.voteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {

    Button mBtnResults, mBtnReg, mBtnOut;
    TextView edtRegEmail, edtRegPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegPassword = findViewById(R.id.edtRegPassword);
        mBtnReg = findViewById(R.id.btnReg);
        mBtnResults = findViewById(R.id.btnResults);
        mBtnOut = findViewById(R.id.btnOut);
        mAuth = FirebaseAuth.getInstance();

        //Button TO view results page
        mBtnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, ResultsActivity.class));
            }
        });

        //Log Out Button
        mBtnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, LogActivity.class));
            }
        });

        //Create Log in credential button
        mBtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerVoter();
            }
        });
    }

    //creating log in method
    private void registerVoter() {
        String mail = edtRegEmail.getText().toString();
        String pass = edtRegPassword.getText().toString();

        if (mail.isEmpty()) {
            edtRegEmail.setError("Email Required");
            edtRegEmail.requestFocus();
        } else if (pass.isEmpty()) {
            edtRegPassword.setError("Password Required");
            edtRegPassword.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(AdminActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(AdminActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                    edtRegEmail.setText("");
                    edtRegPassword.setText("");
                }
            });
        }
    }
}