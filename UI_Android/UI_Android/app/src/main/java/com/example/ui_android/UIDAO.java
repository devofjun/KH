package com.example.ui_android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UIDAO extends SQLiteOpenHelper {
    private static UIDAO instance;

    private UIDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static UIDAO getInstance(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        if(instance == null){
            instance = new UIDAO(context, name, factory, version);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    // 테이블 생성
        String sql = "create table TBL_STUDENT(" +
                "    SNO char(8) constraint pk_SNO primary key," +
                "    SNAME char(10) not null," +
                "    SYEAR int not null," +
                "    GENDER char(3) not null," +
                "    MAJOR char(10) not null," +
                "    SCORE int default 0 constraint score_nn not null," +
                "    constraint score_chk check(SCORE between 0 and 100)," +
                "    constraint syear_chk check(SYEAR between 0 and 9)" +
                ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //
    }

    // 전체 검색
    public ArrayList<UIVO> selectAll() {
        String sql = "select * from TBL_STUDENT";
        // 결과를 넘겨주기 위한 arraylist 생성
        ArrayList<UIVO> voList = new ArrayList<>();
        // 데이터베이스 실행(?)
        SQLiteDatabase db = this.getReadableDatabase();
        // sql쿼리 실행
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            UIVO vo = new UIVO();
            vo.setSNO(cursor.getString(0));
            vo.setSNAME(cursor.getString(1));
            vo.setSYEAR(cursor.getInt(2));
            vo.setGENDER(cursor.getString(3));
            vo.setMAJOR(cursor.getString(4));
            vo.setSCORE(cursor.getInt(5));
            voList.add(vo);
        }
        return voList;
    }

    // 등록하기
    public boolean insertStudent(String SNO, String SNAME, int SYEAR, String GENDER, String MAJOR, int SCORE){
        String sql = "insert into ";
        SQLiteDatabase db = this.getWritableDatabase();
        // insert 완성하기
        return false;
    }
}
