package com.example.taeyoung.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements android.widget.RadioGroup.OnCheckedChangeListener{
    TextView text1, text2;
    Switch switAgree;
    RadioGroup rGroup;
    RadioButton jelly, kitkat, lollipop;
    Button finish, refresh;
    ImageView imgVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switAgree = (Switch) findViewById(R.id.switAgree);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        jelly = (RadioButton) findViewById(R.id.jelly);
        kitkat = (RadioButton) findViewById(R.id.kitkat);
        lollipop = (RadioButton) findViewById(R.id.lollipop);

        finish = (Button) findViewById(R.id.finishBtn);
        refresh = (Button) findViewById(R.id.refreshBtn);
        imgVer = (ImageView) findViewById(R.id.imgVer);

        rGroup.setOnCheckedChangeListener(this);

        switAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (switAgree.isChecked()) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup.setVisibility(android.view.View.VISIBLE);
                    finish.setVisibility(android.view.View.VISIBLE);
                    refresh.setVisibility(android.view.View.VISIBLE);
                    imgVer.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup.setVisibility(android.view.View.INVISIBLE);
                    refresh.setVisibility(android.view.View.INVISIBLE);
                    finish.setVisibility(android.view.View.INVISIBLE);
                    imgVer.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                jelly.setChecked(false);
                kitkat.setChecked(false);
                lollipop.setChecked(false);
                imgVer.setImageResource(0);
            }
        });


    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(rGroup.getCheckedRadioButtonId() == R.id.jelly)
            imgVer.setImageResource(R.drawable.jelly);
        if(rGroup.getCheckedRadioButtonId() == R.id.kitkat)
            imgVer.setImageResource(R.drawable.kitkat);
        if(rGroup.getCheckedRadioButtonId() == R.id.lollipop)
            imgVer.setImageResource(R.drawable.lollipop);
    }


}
