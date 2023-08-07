package com.firstapp.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.*;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, Button> buttons = new HashMap<>();
    private ArrayList<String> history = new ArrayList<>();
    private Button lastUsed;
    private String expression = "";
    private double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButtons((ViewGroup) findViewById(android.R.id.content).getRootView());
    }

    public void getButtons(ViewGroup layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            if (view instanceof Button) {
                view.setOnClickListener(v -> {
                    TextView display = findViewById(R.id.textView);

                    if (expression == null || expression.equals("")) {
                        Toast.makeText(getApplicationContext(), "Input a number first.", Toast.LENGTH_LONG).show();
                    } else {
                        if (!Character.isDigit(expression.charAt(0))) {
                            switch (((Button) view).getText().toString()) {
                                case "+":
                                    expression += "+";
                                    break;
                                case "-":
                                    expression += "-";
                                    break;
                                case "*":
                                    expression += "*";
                                    break;
                                case "/":
                                    expression += "/";
                                    break;
                                case "=":
                                    expression += "=";
                                    break;
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Input a number first.", Toast.LENGTH_LONG).show();
                        }
                    }

                    if (!expression.contains("=")) {
                        display.setText(expression);
                    } else {
                        value = calculate();
                        display.setText(String.valueOf(value));
                    }
                });
                buttons.put(view.getId(), (Button) view);
            }
        }

        System.out.println("finished adding buttons!");
    }


    public double calculate() {
        double result = 0.0;
        if (expression.contains("+")) {
            String[] items = expression.split("+");
            double num1 = Double.parseDouble(items[0]);
            double num2 = Double.parseDouble(items[1]);
            result = num1 + num2;

        } else if (expression.contains("-")) {

        } else if (expression.contains("*")) {

        } else if (expression.contains("/")) {

        }

        return result;
    }

}