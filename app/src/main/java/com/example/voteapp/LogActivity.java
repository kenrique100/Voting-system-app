package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {

    EditText edtEmail , edtPassword;
    Button mBtnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        mBtnLog = findViewById(R.id.btnLog);



        //Login To Admin Account
        mBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                if (email.equals("") && pass.equals("")){
                    Toast.makeText(LogActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }

                else if (email.equals("gregorymark254@gmail.com") && pass.equals("2022")){
                    Toast.makeText(LogActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent success = new Intent(LogActivity.this,AdminActivity.class);
                    startActivity(success);
                    edtEmail.setText("");
                    edtPassword.setText("");
                }
                else {
                    Toast.makeText(LogActivity.this, "Invalid login credentials. Please try again.", Toast.LENGTH_SHORT).show();
                    edtEmail.setText("");
                    edtPassword.setText("");
                }
            }
        });
    }
}