package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button mBtnVoter, mBtnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mBtnVoter = findViewById(R.id.btnVoter);
        mBtnAdmin = findViewById(R.id.btnAdmin);

        mBtnVoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(WelcomeActivity.this, UserActivity.class);
                startActivity(next);
            }
        });

        mBtnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(WelcomeActivity.this, LogActivity.class);
                startActivity(next);
            }
        });
    }

}