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

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {

    private Spinner fourth;
    Button mBtnFinance;
    Member member;
    int maxid = 1 ;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        //Spinner value to be displayed in the drop down
        List<String> Finance = new ArrayList<>();
        Finance.add("Choose Your Finance Manager ");
        Finance.add("Candidate 1");
        Finance.add("Candidate 2");
        Finance.add("Candidate 3");
        Finance.add("Candidate 4");
        ArrayAdapter<String> dataAdapter;

        fourth = findViewById(R.id.spFinance);
        mBtnFinance = findViewById(R.id.btnFinance);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        member = new Member();


        //Creating the ArrayAdapter instance having the Finance list
        dataAdapter  = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Finance);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        fourth.setAdapter(dataAdapter);

        //Performing action onItemSelected and onNothing selected on the spinner bar
        fourth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), Finance.get(i), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
        mBtnFinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setFourth(fourth.getSelectedItem().toString());
                Toast.makeText(FourthActivity.this, "Vote Added Successful", Toast.LENGTH_SHORT).show();
                mDatabase.child("Finance").child(String.valueOf(maxid+1)).setValue(member);

                //If Successful go to next activity
                Intent next = new Intent(FourthActivity.this, FivethActivity.class);
                startActivity(next);
            }
        });
    }
}