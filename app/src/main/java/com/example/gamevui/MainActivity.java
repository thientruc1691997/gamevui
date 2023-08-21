package com.example.gamevui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtNumber;
    TextView myResult;

    TextView visibleText1;
    Button btnRandom;
    EditText myNumb;

    Button btnSubmit;
    public int value;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = findViewById(R.id.textViewNumber);
        btnRandom = findViewById(R.id.buttonRandom);
        myNumb = findViewById(R.id.myNumber);
        btnSubmit = findViewById(R.id.submit);
        myResult = findViewById(R.id.result);
        visibleText1 = findViewById(R.id.visibleText);

        myNumb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0)
                    visibleText1.setVisibility(View.INVISIBLE);
                else visibleText1.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnSubmit.setOnClickListener(view -> {

            String strValue = myNumb.getText().toString();
            myNumb.setText(strValue);
            //myNumb.setKeyListener(null);
            myResult.setText(compareResult(Integer.valueOf(myNumb.getText().toString()), Integer.valueOf(txtNumber.getText().toString())));

        });

        btnRandom.setOnClickListener(view -> {

            Random random = new Random();
            int number = random.nextInt(100);
            txtNumber.setText(number + "");


        });


    }

    private String compareResult(int inputNumber, int randomNumber) {
        double num = inputNumber - randomNumber;
        if (num < 0) {
            return inputNumber + " < " + randomNumber;
        } else if (num > 0) {
            return inputNumber + " > " + randomNumber;
        } else {
            return inputNumber + " = " + randomNumber;
        }
    }
}