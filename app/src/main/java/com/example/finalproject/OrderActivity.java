package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mySpinner;
    Fragment showResultFragment;
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mySpinner = findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       String text = parent.getItemAtPosition(position).toString();
        if (text.equals("Coffee with tea 25 taka")) {
            showResultFragment = new result();

        }

        else if (text.equals("Black Coffee 25 taka")) {
            showResultFragment = new result();

        }
        else if (text.equals("Filter Coffee 25 taka")) {
            showResultFragment = new result();

        }

        else {
            showResultFragment = new BlankFragment();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, showResultFragment);
        ft.commit();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void back(View view) {
        Intent myIntent = new Intent(this,LogInActivity.class);
        startActivity(myIntent);
        
    }
}