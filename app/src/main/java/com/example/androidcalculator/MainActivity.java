package com.example.androidcalculator; // make sure this matches YOUR package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputFirstNumber, inputSecondNumber;
    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect variables to UI elements
        inputFirstNumber  = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        buttonPlus        = findViewById(R.id.buttonPlus);
        buttonMinus       = findViewById(R.id.buttonMinus);
        buttonMultiply    = findViewById(R.id.buttonMultiply);
        buttonDivide      = findViewById(R.id.buttonDivide);
        textResult        = findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });
    }

    private void calculate(String operator) {
        String first  = inputFirstNumber.getText().toString();
        String second = inputSecondNumber.getText().toString();

        // Check that both fields are filled
        if (first.isEmpty() || second.isEmpty()) {
            textResult.setText("Result: Please enter both numbers");
            return;
        }

        double num1   = Double.parseDouble(first);
        double num2   = Double.parseDouble(second);
        double result;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    textResult.setText("Result: Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                return;
        }

        textResult.setText("Result: " + result);
    }
}