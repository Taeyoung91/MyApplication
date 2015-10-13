package com.example.taeyoung.calc2;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText edit1, edit2;
    TextView textResult;
    Double result;
    String num1, num2;

    Button[] numButtons = new Button[10];
    Integer[] calcBtnIDs = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv};
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8,
            R.id.BtnNum9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("calc2");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        textResult = (TextView) findViewById(R.id.textResult);

        for(int i = 0; i < numBtnIDs.length; i++)
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);

        for(int i = 0; i < numBtnIDs.length; i++) {

            final int index;
            index = i;

            numButtons[i].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused() == true){
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }



        for(int i = 0; i < calcBtnIDs.length; i++)
            findViewById(calcBtnIDs[i]).setOnClickListener(calcOnGrid);

    }


    Button.OnClickListener calcOnGrid = new View.OnClickListener(){
        public void onClick(View v){
            String tmp1 = edit1.getText().toString();
            String tmp2 = edit2.getText().toString();

            if(tmp1.equals("") || tmp2.equals("")){
                Toast.makeText(getApplicationContext(),"값을 입력하세요", Toast.LENGTH_SHORT).show();
            }

            else{
                Double num1 = Double.parseDouble(tmp1);
                Double num2 = Double.parseDouble(tmp2);

                switch(v.getId()){
                    case R.id.btnAdd:
                        result = num1 + num2;
                        break;
                    case R.id.btnSub:
                        result = num1 - num2;
                        break;
                    case R.id.btnMul:
                        result = num1 * num2;
                        break;
                    case R.id.btnDiv:
                        if(num2==0){
                            Toast.makeText(getApplicationContext(), "분모가 0입니다", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else{
                            result = num1 / num2;
                            break;
                        }
                }
                textResult.setText("계산 결과 : " + result.toString());
            }

        }
    };

}
