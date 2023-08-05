package com.firstapp.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, Button> buttons = new HashMap<>();
    private ArrayList<String> history = new ArrayList<>();
    private Button lastUsed;
    private String expression;
    private double value;
    private int numClicks; // keep track of number, operator oscillation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButtons(findViewById(R.layout.activity_main).getRootView());
    }

    public void getButtons(ViewGroup layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            if (view instanceof Button) {
                view.setOnClickListener(l -> {
                    TextView display = findViewById(R.id.textView);
                    display.setText(((Button) view).getText());
                });
                buttons.put(((Button) view).getId(), (Button) view);
            }
        }

        System.out.println("finished adding buttons!");
    }

    public void onClick(View view) {
        if (expression.equals("")) {
            Toast.makeText(getApplicationContext(), "Input a number first.", Toast.LENGTH_LONG).show();
        } else {
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
            }
            value = parseExpression();
        }
    }


    public double parseExpression() {
        String expressionOperators = "+-*/";

        if (expression.contains("+")) {

        }

        return 0.0;
    }

}