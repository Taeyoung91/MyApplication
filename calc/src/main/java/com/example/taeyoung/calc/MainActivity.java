package com.example.taeyoung.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText numberFirst, numberSecond;
    Button buttonAdd, buttonMinus, buttonMultiple, buttonDivision;
    TextView textResult;
    String number1, number2;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");
        numberFirst = (EditText) findViewById(R.id.numberFirst);
        numberSecond = (EditText) findViewById(R.id.numberSecond);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiple = (Button) findViewById(R.id.buttonMultiple);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        textResult = (TextView) findViewById(R.id.textResult);

        buttonAdd.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                result = Double.parseDouble(number1) + Double.parseDouble(number2);
                textResult.setText("계산 결과 :" + result.toString());
                return false;
            }
        });
        buttonMinus.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                result = Double.parseDouble(number1) - Double.parseDouble(number2);
                textResult.setText("계산 결과 :" + result.toString());
                return false;
            }
        });
        buttonMultiple.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                result = Double.parseDouble(number1) * Double.parseDouble(number2);
                textResult.setText("계산 결과 :" + result.toString());
                return false;
            }
        });
        buttonDivision.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                result = Double.parseDouble(number1) / Double.parseDouble(number2);
                textResult.setText("계산 결과 :" + result.toString());
                return false;
            }
        });
    }
}
