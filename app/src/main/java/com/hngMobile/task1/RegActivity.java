package com.hngMobile.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class RegActivity extends AppCompatActivity {

    private UserSession session;
    private Button btnLogout;

    public static final String EXTRA_MESSAGE = "Name";
    public static final String EXTRA_MESSAGE1 = "Username";
    public static final String EXTRA_MESSAGE2 = "Phone No";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = this.getSharedPreferences("myapp",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        btnLogout  = (Button) findViewById(R.id.logout);
        session  = new UserSession(this);
        if(!session.getLoggedin()){
            Logout();
        }
        Intent intent = getIntent();
        String messageText = intent.getStringExtra("Name");
        String message2 = intent.getStringExtra("Username");
        String message3 = intent.getStringExtra("Phone No");
        TextView uEmail = (TextView)findViewById(R.id.UsersEmail);
        TextView uPhone = (TextView)findViewById(R.id.UsersPhoneNumber);
        TextView uName = (TextView)findViewById(R.id.UsersName);
        uName.setText(pref.getString("name","missing"));
        uEmail.setText("Your Email: "+pref.getString("Email","missing"));
        uPhone.setText("Your Phone Number: "+pref.getString("phone","null"));
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setLoggedin(false);
                finish();
                startActivity(new Intent(RegActivity.this,MainActivity.class));
            }
        });

    }

    public void Logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(RegActivity.this,MainActivity.class));
    }

}
