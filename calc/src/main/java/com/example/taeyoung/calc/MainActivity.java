package com.example.taeyoung.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText numberFirst, numberSecond;
    Button buttonAdd, buttonMinus, buttonMultiple, buttonDivision, buttonRest;
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
        buttonRest = (Button) findViewById(R.id.buttonRest);
        textResult = (TextView) findViewById(R.id.textResult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                if(number1.equals("") || number2.equals("")){
                    Toast.makeText(MainActivity.this,"값을 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(number1) + Double.parseDouble(number2);
                    textResult.setText("계산 결과 :" + result.toString());
                }
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                if(number1.equals("") || number2.equals("")){
                    Toast.makeText(MainActivity.this,"값을 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(number1) - Double.parseDouble(number2);
                    textResult.setText("계산 결과 :" + result.toString());
                }
            }
        });
        buttonMultiple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                if(number1.equals("") || number2.equals("")){
                    Toast.makeText(MainActivity.this,"값을 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(number1) * Double.parseDouble(number2);
                    textResult.setText("계산 결과 :" + result.toString());
                }
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                if(number1.equals("") || number2.equals("")){
                    Toast.makeText(MainActivity.this,"값을 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else if(number2.equals("0")){
                    Toast.makeText(MainActivity.this,"분모가 0입니다.",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(number1) / Double.parseDouble(number2);
                    textResult.setText("계산 결과 :" + result.toString());
                }
            }
        });
        buttonRest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number1 = numberFirst.getText().toString();
                number2 = numberSecond.getText().toString();
                if(number1.equals("") || number2.equals("")){
                    Toast.makeText(MainActivity.this,"값을 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else if (number2.equals("0")) {
                    Toast.makeText(MainActivity.this, "분모가 0입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(number1) % Double.parseDouble(number2);
                    textResult.setText("계산 결과 :" + result.toString());
                }
            }
        });

    }
}
