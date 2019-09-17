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
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new UserSession(this);

        if(session.getLoggedin()){
            Intent intent = new Intent(this, RegActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void Login(View view){
        DataStore store = new DataStore();

        EditText  user = (EditText) findViewById(R.id.user);
        EditText password = (EditText) findViewById(R.id.password);
        String username = user.getText().toString();
        String pass = password.getText().toString();
        if(username.length() == 0){
            user.requestFocus();
            user.setError("please input username");
        }else if(pass.length() == 0){
            password.requestFocus();
            password.setError("please input password");
        }else {
            File UserDetails = getFilesDir();
            File Details =   new File(UserDetails,"userdetails.txt");
            try {
                Scanner reader = new Scanner(Details);
                while(reader.hasNextLine()){
                    String[] Data = reader.nextLine().split(",");

                    if((Data[0].equals(username)) || (Data[2].equals(username))) {
                        if (Data[4].equals(pass)) {
                            session.setLoggedin(true);
                            session.setDetails(Data);

                            Intent intent = new Intent(this, RegActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(this, "Username/Password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
////        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE,messageText);
////        intent.putExtra("message",messageText);
////        startActivity(intent);
        }
    }
    public void Register(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
