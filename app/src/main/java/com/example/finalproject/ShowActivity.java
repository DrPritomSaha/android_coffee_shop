package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView = findViewById(R.id.result);
        Intent intent = getIntent();
        String s = intent.getStringExtra("key");
        textView2 = findViewById(R.id.coffeItem);
        textView2.setText("Total order : " + s);

        int myresult = Integer.parseInt(s) * 25;
        textView.setText("Total Price " + myresult + "");

    }

    public void back(View view) {
        Intent myIntent = new Intent(this, LogInActivity.class);
        startActivity(myIntent);
    }
}