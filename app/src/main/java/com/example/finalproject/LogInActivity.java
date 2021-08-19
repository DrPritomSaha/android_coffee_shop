package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    public static final String Create = "This comes from Log In Page";
    EditText username, password;
    Button btnlogin, delete;
    DBHelper DB;
    Fragment showResultFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);
        delete =  findViewById(R.id.btnDelete);


    }

    public void create(View view) {

        Intent myIntent = new Intent(this, CreateAccount.class);
        myIntent.putExtra(Create, 0);
        startActivity(myIntent);

    }


    public void logIn(View view) {
        showResultFragment = new LogConfirm();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, showResultFragment);
        ft.commit();

    }





    public void back(View view) {
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}