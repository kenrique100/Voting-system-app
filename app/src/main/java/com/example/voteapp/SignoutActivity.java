package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignoutActivity extends AppCompatActivity {

    Button mBtnSignout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);

        mBtnSignout = findViewById(R.id.btnSignout);


        //Logging Out Button
        mBtnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent next = new Intent(SignoutActivity.this,WelcomeActivity.class);
                startActivity(next);
            }
        });
    }
}