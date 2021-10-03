package com.example.homeworkassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class MainActivity extends AppCompatActivity {


    Map<String,String> unitsMap = new HashMap<>();
    final String GRAMS = "Grams";
    final String KILOGRAMS = "Kilograms";
    final String CENTIMETER = "Centimeter";
    final String METER = "Meter";
    final String OUNCE = "Ounce";
    final String POUNDS = "Pounds";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // unitsMap will contain the From unit to To Unit
        // e.g. Grams -> Kilograms
        unitsMap.put(GRAMS,KILOGRAMS);
        unitsMap.put(CENTIMETER,METER);
        unitsMap.put(OUNCE,POUNDS);
        // get all the keys from map and create a new ArrayList
        List<String> keys = new ArrayList<String>(unitsMap.keySet());
        // help to get the random number
        Random r = new Random();
        // get random number from 0 to size - 1 and then get the key at that random location from the arraylist
        String randomFromUnit = keys.get(r.nextInt(keys.size()));
        String randomToUnit = unitsMap.get(randomFromUnit);

        //main activity
        TextView headText = (TextView) findViewById(R.id.headTextView);
        TextView fromTxt = (TextView) findViewById(R.id.fromTxt);
        TextView toTxt = (TextView) findViewById(R.id.toTxt);
        // update from and to text with the selected random unit pair
        fromTxt.setText(fromTxt.getText() + " " + randomFromUnit);
        toTxt.setText(toTxt.getText() + " " + randomToUnit);

        EditText userNum = (EditText) findViewById(R.id.editTextNumber);

        //User input display
        Button mainButton = (Button) findViewById(R.id.mainButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, OutputActivity.class);
                Double userInput = Double.valueOf(userNum.getText().toString());
                intent.putExtra ("inputNumber", userInput );
                intent.putExtra ("fromUnit", randomFromUnit );
                intent.putExtra ("toUnit", randomToUnit );
                Double convertedValue = this.convert(userInput,randomFromUnit,randomToUnit);
                intent.putExtra ("convertedValue", convertedValue );
                startActivity(intent);

            }

            private Double convert(Double userInput, String randomFromUnit, String randomToUnit) {
                Double convertedValue = null;
                switch (randomFromUnit){
                    case GRAMS:
                        convertedValue = userInput / 1000;
                        break;
                    case CENTIMETER:
                        convertedValue = userInput / 100;
                        break;
                    case OUNCE:
                        convertedValue = userInput / 16;
                        break;
                }

                return convertedValue;
            }
        });

    }
}















