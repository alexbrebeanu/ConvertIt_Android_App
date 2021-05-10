package com.example.convertit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.weigthButton:
                Intent toWeight = new Intent(this, WeightActivity.class);
                startActivity(toWeight);
                break;
            case R.id.lengthButton:
                Intent toLength = new Intent(this, LengthActivity.class);
                startActivity(toLength);
                break;
            case R.id.tempButton:
                Intent toTemp = new Intent(this, TempActivity.class);
                startActivity(toTemp);
                break;
        }

    }

    private Button weightBtn;
    private Button lengthBtn;
    private Button tempBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //Create intents to for each activity i want to switch to


        weightBtn = findViewById(R.id.weigthButton);
        weightBtn.setOnClickListener(this);
        lengthBtn = findViewById(R.id.lengthButton);
        lengthBtn.setOnClickListener(this);
        tempBtn = findViewById(R.id.tempButton);
        tempBtn.setOnClickListener(this);


    }
}