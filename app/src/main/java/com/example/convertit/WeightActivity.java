package com.example.convertit;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.text.DecimalFormat;

public class WeightActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        //get input value
        c = Double.parseDouble(inWeight.getText().toString());
        //First turn into kilograms
        switch(weightFrom){
            case "Kilograms":
                c = c;
                break;
            case "Grams":
                c = c/1000;
                break;
            case "Milligrams":
                c = c/1000000;
                break;
            case "Pounds":
                c = c/2.20462;
                break;
            case "Ounces":
                c = c/35.274;
                break;
        }

        //Now turn into the needed unit
        switch(weightTo){
            case "Kilograms":
                c = c;
                break;
            case "Grams":
                c = c*1000;
                break;
            case "Milligrams":
                c = c*100000;
                break;
            case "Pounds":
                c = c*2.20462;
                break;
            case "Ounces":
                c = c*35.274;
                break;
        }
        outWeight.setText(numberFormatWeight.format(c));
    }

    private TextView outWeight;
    private EditText inWeight;
    private Spinner weightSpinFrom;
    private Spinner weightSpinTo;
    private Button convertWeight;
    private String weightFrom;
    private String weightTo;
    private Double c;
    private DecimalFormat numberFormatWeight = new DecimalFormat("#.00");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_layout);

        //change theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //Button
        convertWeight = findViewById(R.id.weightConvert);
        convertWeight.setOnClickListener(this);

        //input weight
        inWeight = findViewById(R.id.weightInput);

        //output weight
        outWeight = findViewById(R.id.weightOut);

        //Spinners
        weightSpinFrom = findViewById(R.id.unitsWeight);
        weightSpinTo = findViewById(R.id.changeToWeight);

        Resources resWeight = getResources();
        ArrayAdapter<String> adapterWeight = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resWeight.getStringArray(R.array.weight_units)
        );

        weightSpinFrom.setAdapter(adapterWeight);
        weightSpinTo.setAdapter(adapterWeight);

        weightSpinFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weightFrom = weightSpinFrom.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        weightSpinTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weightTo = weightSpinTo.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
