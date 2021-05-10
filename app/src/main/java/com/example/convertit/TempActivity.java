package com.example.convertit;

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
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;


public class TempActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        b = Double.parseDouble(inTemp.getText().toString());
        //First turn to celsius
        switch(tempFrom){
            case "Fahrenheit":
                b = (b-32)/1.8;
                break;
            case "Celsius":
                b = b;
                break;
            case "Kelvin":
                b = b-273.15;
                break;
        }

        //Now change to needed unit
        switch(tempTo){
            case "Fahrenheit":
                b = (b*1.8)+32;
                break;
            case "Celsius":
                b = b;
                break;
            case "Kelvin":
                b = b + 273.15;
                break;
        }

        outTemp.setText(numberFormatTemp.format(b));
    }

    private DecimalFormat numberFormatTemp = new DecimalFormat("#.00");
    private TextView outTemp;
    private EditText inTemp;
    private Spinner tempSpinFrom;
    private Spinner tempSpinTo;
    private Button convertTemp;
    private String tempFrom;
    private String tempTo;
    private Double b;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);

        //change theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //Button
        convertTemp = findViewById(R.id.tempConvert);
        convertTemp.setOnClickListener(this);

        //TextView
        outTemp = findViewById(R.id.tempOut);

        inTemp = findViewById(R.id.tempInput);


        //Spinners
        tempSpinFrom = findViewById(R.id.unitsTemp);
        tempSpinTo = findViewById(R.id.changeToTemp);
        Resources resTemp  = getResources();
        ArrayAdapter<String> adapterTemp = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                resTemp.getStringArray(R.array.units_temp)
        );

        tempSpinTo.setAdapter(adapterTemp);
        tempSpinFrom.setAdapter(adapterTemp);

        //spinner Listeners
        tempSpinFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempFrom = tempSpinFrom.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tempSpinTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempTo = tempSpinTo.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
