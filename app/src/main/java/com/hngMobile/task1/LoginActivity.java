package com.hngMobile.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void Register(View v)  {
//        DataStore store = new DataStore();

        EditText user = (EditText) findViewById(R.id.user);
        EditText password = (EditText) findViewById(R.id.password);
        EditText Name = (EditText) findViewById(R.id.Name);
        EditText confpassword = (EditText) findViewById(R.id.Confpassword);
        EditText Email = (EditText) findViewById(R.id.Email);
        EditText Phone = (EditText) findViewById(R.id.Phone);

        String EmailAddr = Email.getText().toString();
        String name = Name.getText().toString();
        String username = user.getText().toString();
        String Password = password.getText().toString();
        String password2 = confpassword.getText().toString();
        String PhoneNo = Phone.getText().toString();

        if (EmailAddr.length() == 0) {
            Email.requestFocus();
            Email.setError("please input value");
        }
        if (name.length() == 0) {
            Name.requestFocus();
            Name.setError("please input value");
        }
        if (username.length() == 0) {
            user.requestFocus();
            user.setError("please input value");
        }
        if (PhoneNo.length() == 0) {
            Phone.requestFocus();
            Phone.setError("please input value");
        }
        if (Password.length() == 0) {
            password.requestFocus();
            password.setError("please input value");
        }
        if (password2.length() == 0) {
            confpassword.requestFocus();
            confpassword.setError("please input value");
        }
        else {
            if(Password.equals(password2)){
                String[] userDetails = {EmailAddr,name,username,PhoneNo,Password};
                File UserDetails = getFilesDir();
                File Details =   new File(UserDetails,"userdetails.txt");
                try {
//
                    BufferedWriter writer = new BufferedWriter(new FileWriter(Details,true));
                    for(int i=0; i<userDetails.length; i++){
                        writer.write(userDetails[i]+",");
                    }
                    writer.newLine();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this, "You have been registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                password.requestFocus();
                Toast.makeText(this, Password, Toast.LENGTH_SHORT).show();
                password.setError("please input value");
                confpassword.requestFocus();
                Toast.makeText(this, password2, Toast.LENGTH_SHORT).show();
                confpassword.setError("please input value");

            }
        }
    }

    public void Login(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
