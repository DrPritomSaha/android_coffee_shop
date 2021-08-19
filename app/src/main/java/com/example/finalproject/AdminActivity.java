package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    Button insert, update, delete, view;
    DBHelper DB;
    EditText username;
    TextView admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);




        delete = findViewById(R.id.btnDelete);
        username = findViewById(R.id.name1);
        admin = findViewById(R.id.adminName);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);
        Intent intent = getIntent();
        String s = intent.getStringExtra("key");
        admin.setText("Admin Name : " +s);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(AdminActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name :" + res.getString(0) + "\n");


                }
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Oky");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nameTXT = username.getText().toString();
                Boolean check = DB.deletedata(nameTXT);
                if (check == true)
                    Toast.makeText(AdminActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void back(View view) {

            Intent myIntent = new Intent(this,MainActivity.class);
            startActivity(myIntent);
        }

}