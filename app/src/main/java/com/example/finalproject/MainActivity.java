package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText myText;
    public static final String FirstExtra = "This comes from first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickForOrder(View view) {
        Intent myIntent = new Intent(this, LogInActivity.class);
        myIntent.putExtra(FirstExtra, 0);
        startActivity(myIntent);
    }


    public void aboutUs(View view) {
        Intent myAbout = new Intent(this, AboutActivity.class);
        myAbout.putExtra(FirstExtra, 0);
        startActivity(myAbout);

    }
}