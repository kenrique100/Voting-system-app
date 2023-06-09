package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultsActivity extends AppCompatActivity {

    Button mBtnChair, mBtnPres, mBtnSec, mBtnFin, mBtnWelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mBtnChair = findViewById(R.id.btnChair);
        mBtnPres = findViewById(R.id.btnPres);
        mBtnSec = findViewById(R.id.btnSec);
        mBtnFin = findViewById(R.id.btnFin);
        mBtnWelf = findViewById(R.id.btnWelf);

        //President Reports
        mBtnPres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ResultsActivity.this, RecyclerActivity.class);
                startActivity(next);
            }
        });

        //Chairman Reports
        mBtnChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ResultsActivity.this, ChairActivity.class);
                startActivity(next);
            }
        });

        //Secretary Reports
        mBtnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ResultsActivity.this, SecActivity.class);
                startActivity(next);
            }
        });

        //Finance Reports
        mBtnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ResultsActivity.this, FinanceActivity.class);
                startActivity(next);
            }
        });

        //Welfare Reports
        mBtnWelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ResultsActivity.this, WelfActivity.class);
                startActivity(next);
            }
        });
    }
}