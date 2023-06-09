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

public class UserActivity extends AppCompatActivity {

    TextView edtVoter, edtVotePassword;
    Button mBtnLogin;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mAuth = FirebaseAuth.getInstance();
        edtVoter = findViewById(R.id.edtVoter);
        edtVotePassword = findViewById(R.id.edtVotePassword);
        mBtnLogin = findViewById(R.id.btnLogin);


        //Log in Button To Account
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logUser();
            }
        });
    }

    //sign in user
    private void logUser() {
        String email = edtVoter.getText().toString();
        String password = edtVotePassword.getText().toString();

        if (email.isEmpty()) {
            edtVoter.setError("Email Required");
            edtVoter.requestFocus();
        } else if (password.isEmpty()) {
            edtVotePassword.setError("Password Required");
            edtVotePassword.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(UserActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(UserActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UserActivity.this, StartActivity.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(UserActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                    edtVoter.setText("");
                    edtVotePassword.setText("");
                }
            });
        }
    }
}