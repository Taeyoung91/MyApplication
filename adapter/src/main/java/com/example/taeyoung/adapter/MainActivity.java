package com.example.taeyoung.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Integer[] movID = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5, R.drawable.mov6,
            R.drawable.mov7, R.drawable.mov8, R.drawable.mov9, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12,
            R.drawable.mov13, R.drawable.mov14, R.drawable.mov15, R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
            R.drawable.mov19, R.drawable.mov20, R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24,
            R.drawable.mov25, R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29, R.drawable.mov30};

    String[] movName = {"신세계", "괴물", "하울링", "수퍼맨 리턴즈", "타이타닉", "감시자들", "파파로티", "완득이", "본 레거시",
            "레미제라블", "설국열차", "마더", "여친소", "더 울버린", "내머리속의 지우개", "안녕, 형아", "해운대", "명량", "과속 스캔들", "Her",
            "님은 먼 곳에", "블랙 스완", "내 아내의 모든 것", "친구2", "워낭소리", "도둑들", "포화속으로", "숨바꼭질", "비열한 거리", "아바타"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = (GridView) findViewById(R.id.grid);
        MyGridAdapter myGridAdapter = new MyGridAdapter(this);
        gridView.setAdapter(myGridAdapter);

    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        LayoutInflater layoutInflater;

        public MyGridAdapter(Context context) {
            this.context = context;
            layoutInflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.convertview,parent,false);
            }
            ImageView imageView = (ImageView)convertView.findViewById(R.id.convertImg);
            imageView.setImageResource(movID[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            TextView textView = (TextView)convertView.findViewById(R.id.convertText);
            textView.setText(movName[position]);

            final int pos = position;

            imageView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    View dialogView =  View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.imgPoster);
                    ivPoster.setImageResource(movID[pos]);
                    dlg.setTitle(movName[pos]);
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return convertView;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        public int getCount() {
            return movID.length;
        }
    }

}

