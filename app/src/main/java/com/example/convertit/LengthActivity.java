package com.example.convertit;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.text.DecimalFormat;

public class LengthActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        a = Double.parseDouble(inputLen.getText().toString());
        //First turn a to meters
        switch (conFrom){
            case "Meters":
                a = a;
                break;
            case "Kilometers":
                a = a*1000;
                break;
            case "Centimeters":
                a = a / 100;
                break;
            case "Miles":
                a = a * 1609.34;
                break;
            case "Inches":
                a = a / 39.37;
                break;
            case "Feet":
                a = a / 3.28084;
                break;
        }
        //Now turn a from meters to unit needed
        switch(conTo){
            case "Meters":
                a = a;
                break;
            case "Kilometers":
                a = a/1000;
                break;
            case "Centimeters":
                a = a * 100;
                break;
            case "Miles":
                a = a / 1609.34;
                break;
            case "Inches":
                a = a * 39.37;
                break;
            case "Feet":
                a = a * 3.28084;
                break;
        }
        outputLen.setText(numberFormat.format(a));
       // outputLen.setText(a.toString());


    }
    private DecimalFormat numberFormat = new DecimalFormat("#.00");
    private EditText inputLen;
    private TextView outputLen;
    private Spinner lenSpin;
    private Spinner lenSpinTo;
    private Button convert;
    private String conFrom;
    private String conTo;
    private Double a;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_layout);

        //change theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        outputLen = findViewById(R.id.lenOut);




        convert = findViewById(R.id.lenConvert);
        convert.setOnClickListener(this);

        inputLen = findViewById(R.id.lenImput);

        lenSpin =  findViewById(R.id.unitsLength);
        lenSpinTo = findViewById(R.id.changeToLen);
        Resources res = getResources();
        ArrayAdapter<String> adapterLen = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                res.getStringArray(R.array.units_length)
        );
        lenSpin.setAdapter(adapterLen);
        lenSpinTo.setAdapter(adapterLen);

        lenSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conFrom = lenSpin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lenSpinTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conTo = lenSpinTo.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
