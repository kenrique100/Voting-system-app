package com.example.voteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FivethActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    String[] Welfare = {"Choose Your Welfare Manager", "Candidate 1", "Candidate 2", "Candidate 3", "Candidate 4"};
    Button mBtnWelfare;
    Member member;
    int maxid = 1;
    private Spinner fiveth;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiveth);

        mBtnWelfare = findViewById(R.id.btnWelfare);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        member = new Member();

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        fiveth =  findViewById(R.id.spWelfare);
        //spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the Sports list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Welfare);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        fiveth.setAdapter(aa);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Adding Spinner value to firebase
        mBtnWelfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setFiveth(fiveth.getSelectedItem().toString());
                Toast.makeText(FivethActivity.this, "Vote Added Successful", Toast.LENGTH_SHORT).show();
                mDatabase.child("Welfare").child(String.valueOf(maxid+1)).setValue(member);

                //If Successful go to next activity
                Intent next = new Intent(FivethActivity.this, SignoutActivity.class);
                startActivity(next);
            }
        });
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), Welfare[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}