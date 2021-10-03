package com.example.homeworkassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView outOriginalNumberTextView = (TextView) findViewById(R.id.outOriginalNumber);
        TextView outFromUnitTextView = (TextView) findViewById(R.id.outFromUnit);
        TextView outToUnitTextView = (TextView) findViewById(R.id.outToUnit);
        TextView convertedValueTextView = (TextView) findViewById(R.id.convertedValue);

        // we are passing input as a double so need to get as a double
        Double inputValue = getIntent().getExtras().getDouble("inputNumber");
        outOriginalNumberTextView.setText(inputValue.toString());
        outFromUnitTextView.setText(getIntent().getExtras().getString("fromUnit"));
        outToUnitTextView.setText(getIntent().getExtras().getString("toUnit"));

        // we are passing converted value as a double so need to get as a double
        Double convertedValue = getIntent().getExtras().getDouble("convertedValue");


        //
        convertedValueTextView.setText(String.format("%.2f",convertedValue));


    }

}

