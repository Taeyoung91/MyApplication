package com.example.taeyoung.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHelper myDBHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnModify, btnDel, btnSelect;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNum);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnModify = (Button) findViewById(R.id.btnModify);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        myDBHelper = new MyDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
                btnSelect.callOnClick();
                Toast.makeText(getApplicationContext(), "초기화", Toast.LENGTH_SHORT).show();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myDBHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '" + edtName.getText().toString() + "', '"
                            + edtNumber.getText().toString() + "');");
                sqlDB.close();

                btnSelect.callOnClick();
                Toast.makeText(getApplicationContext(), "입력 완료", Toast.LENGTH_SHORT).show();
            }

        });

        btnModify.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myDBHelper.getWritableDatabase();
                sqlDB.execSQL("UPDATE groupTBL SET gNumber = '" + edtNumber.getText().toString() +
                        "' WHERE gName = '" + edtName.getText().toString() + "';");
                sqlDB.close();

                btnSelect.callOnClick();

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myDBHelper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '" + edtName.getText().toString() + "'");
                sqlDB.close();

                btnSelect.callOnClick();

            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myDBHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹 이름" +"\r\n" + "-------------" + "\r\n";
                String strNumbers = "인원" +"\r\n" + "-------------" + "\r\n";

                while(cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });
    }
    public class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(Context context){
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }


}
