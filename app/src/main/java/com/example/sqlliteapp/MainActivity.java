package com.example.sqlliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add, del, view;

    EditText name,contact;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.addbut);
        view = findViewById(R.id.viewbtn);
        del = findViewById(R.id.delbut);
        name = findViewById(R.id.editText);
        contact = findViewById(R.id.editPhone);

        db = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();

                Boolean checkInsertData = db.addUserData(nameTxt,contactTxt);
                if(checkInsertData){
                    Toast.makeText(MainActivity.this,"New Entry Added",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"An Error Occurred While Adding Data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
//                String contactTxt = contact.getText().toString();

                Boolean deleteData = db.DeleteUserData(nameTxt);
                if(deleteData){
                    Toast.makeText(MainActivity.this,"User Deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"An Error Occurred Please Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);

            }
        });

    }

}