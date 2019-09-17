package com.hngMobile.task1;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession {
    Context ctx;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public UserSession(Context ctx){
        this.ctx = ctx;
        sharedPref = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void setLoggedin(boolean loggedin){
        editor.putBoolean("loginmode",loggedin);
        editor.commit();
    }

    public void setDetails(String[] data){
        editor.putString("name",data[1]);
        editor.putString("Email",data[0]);
        editor.putString("username",data[2]);
        editor.putString("phone",data[3]);
        editor.putString("password",data[4]);
        editor.commit();
    }

    public boolean getLoggedin(){
        return sharedPref.getBoolean("loginmode",false);
    }
}
