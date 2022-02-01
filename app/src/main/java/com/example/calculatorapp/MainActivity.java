//Chi Kien Nguyen (158416180) - Assignment 1
package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    boolean scientificMode = false;
    LinearLayout scientific;
    TextView textView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button_plus;
    Button button_minus;
    Button button_multiply;
    Button button_divide;
    Button button_equal;
    Button button_clear;
    Button button_switch;
    Button button_remainder;
    Button button_power;
    Button button_min;
    Button button_max;

    Calculator calculator = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scientific = findViewById(R.id.scientific);
        textView = findViewById(R.id.equations);
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        button_plus = findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);
        button_minus = findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);
        button_multiply = findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);
        button_divide = findViewById(R.id.button_divide);
        button_divide.setOnClickListener(this);
        button_equal = findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);
        button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);
        button_switch = findViewById(R.id.button_switch);
        button_remainder = findViewById(R.id.button_remainder);
        button_remainder.setOnClickListener(this);
        button_power = findViewById(R.id.button_power);
        button_power.setOnClickListener(this);
        button_min = findViewById(R.id.button_min);
        button_min.setOnClickListener(this);
        button_max = findViewById(R.id.button_max);
        button_max.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.button0:
                calculator.push(button0.getText().toString());
                break;
            case R.id.button1:
                calculator.push(button1.getText().toString());
                break;
            case R.id.button2:
                calculator.push(button2.getText().toString());
                break;
            case R.id.button3:
                calculator.push(button3.getText().toString());
                break;
            case R.id.button4:
                calculator.push(button4.getText().toString());
                break;
            case R.id.button5:
                calculator.push(button5.getText().toString());
                break;
            case R.id.button6:
                calculator.push(button6.getText().toString());
                break;
            case R.id.button7:
                calculator.push(button7.getText().toString());
                break;
            case R.id.button8:
                calculator.push(button8.getText().toString());
                break;
            case R.id.button9:
                calculator.push(button9.getText().toString());
                break;
            case R.id.button_plus:
                calculator.push(button_plus.getText().toString());
                break;
            case R.id.button_minus:
                calculator.push(button_minus.getText().toString());
                break;
            case R.id.button_multiply:
                calculator.push(button_multiply.getText().toString());
                break;
            case R.id.button_divide:
                calculator.push(button_divide.getText().toString());
                break;
            case R.id.button_remainder:
                calculator.push(button_remainder.getText().toString());
                break;
            case R.id.button_power:
                calculator.push(button_power.getText().toString());
                break;
            case R.id.button_min:
                calculator.push(button_min.getText().toString());
                break;
            case R.id.button_max:
                calculator.push(button_max.getText().toString());
                break;
            default:
                // code block
        }
        if(id == R.id.button_equal){
            int result = calculator.calculate();
            if (result == -1) {
                textView.setText(calculator.print() + "=" + " Not an Operator");
            }else{
                textView.setText(calculator.print() + "=" + result);
            }
        }else if(id == R.id.button_clear){
            calculator.delete();
            textView.setText("");
        }else {
            textView.setText(calculator.print());
        }
    }

    public void switchMode(View view) {
        if(scientificMode){
            button_switch.setText("Advanced - Scientific");
            scientific.setVisibility(View.INVISIBLE);
            scientificMode = false;
        }else {
            button_switch.setText("Standard");
            scientific.setVisibility(View.VISIBLE);
            scientificMode = true;
        }
    }
}