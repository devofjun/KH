package com.kh.groupnumberdbex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtName, edtNum;
    Button btnInit, btnInsert, btnSelect, btnUpdate, btnDelete;
    EditText edtNameResult, edtNumberResult;

    MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);

        btnInit.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        helper = new MyDBHelper(MainActivity.this, "groupDB", null, 1);

    }

    @Override
    public void onClick(View v) {
        if(v == btnInit){ // 초기화 버튼 동작
            // 이때 helper의 onCreate가 실행됨.
            SQLiteDatabase db =  helper.getWritableDatabase();
            helper.onUpgrade(db, 1, 2);
            db.close();
            Toast.makeText(this, "테이블 생성됨", Toast.LENGTH_SHORT).show();
        } else if(v == btnInsert) { // 입력 버튼 동작
            String name = edtName.getText().toString();
            String strNum = edtNum.getText().toString();
            int number = Integer.parseInt(strNum);

            String sql = "insert into groupTBL(gName, gNumber) " +
                    "values ('"+name+"', "+number+")";

            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL(sql);
            db.close();
            Toast.makeText(this, "데이터 입력됨", Toast.LENGTH_SHORT).show();
            btnSelect.callOnClick();
        } else if(v == btnSelect) { // 조회 버튼 동작
            select();
            Toast.makeText(this, "조회됨", Toast.LENGTH_SHORT).show();
        } else if(v == btnUpdate) { // 수정 버튼 동작
            String name = edtName.getText().toString();
            String strNum = edtNum.getText().toString();
            int number = Integer.parseInt(strNum);
            String sql = "update groupTBL set gNumber = "+number+" where gName = '"+name+"'";

            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL(sql);
            db.close();
            Toast.makeText(this, "수정됨", Toast.LENGTH_SHORT).show();
            select();
            btnSelect.callOnClick();
        } else if(v == btnDelete) {
            String name = edtName.getText().toString();
            String sql = "delete from groupTBL where gName='"+name+"'";
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL(sql);
            db.close();
            Toast.makeText(this, "삭제됨", Toast.LENGTH_SHORT).show();
            btnSelect.callOnClick();
        }
    }

    private void select() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from groupTBL";
        String strGroup = "그룹 이름\n------------\n";
        String strNumber = "인원\n------------\n";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            strGroup += cursor.getString(0) + "\n";
            strNumber += cursor.getString(1) + "\n";
        }
        edtNameResult.setText(strGroup);
        edtNumberResult.setText(strNumber);
        cursor.close();
        db.close();
    }

    class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // 테이블 생성
            String sql = "create table groupTBL (" +
                    "gName char(20) primary key, " +
                    "gNumber int);";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 기존 테이블 삭제 후 재생성
            String sql = "drop table if exists groupTBL";
            db.execSQL(sql);
            onCreate(db);
        }
    }
}

