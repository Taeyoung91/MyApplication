package com.example.taeyoung.intent;

/**
 * Created by Taeyoung on 2015-11-24.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends Activity {

    Double num1, num2, result;
    Character operation;
    Button btnReturn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("Result Activity");

        Intent intent = getIntent();

        num1 = intent.getDoubleExtra("num1", 0);
        num2 = intent.getDoubleExtra("num2", 0);

        operation = intent.getCharExtra("operation",'+');

        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
            @Override
            public void onClick(View v) {

                if(operation.equals('+')){
                    result = num1 + num2;
                }
                else if(operation.equals('-')){
                    result = num1 - num2;
                }
                else if(operation.equals('*')){
                    result = num1*num2;
                }
                else if(operation.equals('/')){
                    if(num2 == 0){
                        setResult(RESULT_CANCELED, outIntent);
                        finish();
                    }
                    else {
                        result = num1 / num2;
                    }
                }

                outIntent.putExtra("result", result);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
