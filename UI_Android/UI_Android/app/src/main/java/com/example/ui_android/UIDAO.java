package com.example.ui_android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UIDAO extends SQLiteOpenHelper {
    private static UIDAO instance;

    private UIDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static UIDAO getInstance(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        if (instance == null) {
            instance = new UIDAO(context, name, factory, version);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성
        String sql = "create table TBL_STUDENT(" +
                "    SNO char constraint pk_SNO primary key," +
                "    SNAME char not null," +
                "    SYEAR int not null," +
                "    GENDER char not null," +
                "    MAJOR char not null," +
                "    SCORE int default 0 constraint score_nn not null," +
                "    constraint score_chk check(SCORE between 0 and 100)," +
                "    constraint syear_chk check(SYEAR between 0 and 9)," +
                "    constraint sno_chk check(length(SNO)<=8)," +
                "    constraint sname_chk check(length(SNAME)<=3)," +
                "    constraint gender_chk check(length(GENDER)<=1)," +
                "    constraint major_chk check(length(MAJOR)<=3)," +
                "    constraint score_chk check(length(SCORE)<=3)," +
                "    constraint syear_chk2 check(length(SYEAR)<=1)" +
                ");";
        // 한글 기준으로 문자길이 제한했음
        db.execSQL(sql);
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
        while (cursor.moveToNext()) {
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

    // 이름으로 검색
    public ArrayList<UIVO> selectName(String name) {
        ArrayList<UIVO> voList = new ArrayList<UIVO>();
        String sql = "select * from TBL_STUDENT where SNAME Like '%" + name + "%'";
        SQLiteDatabase db = this.getReadableDatabase();
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

    // 전공으로 검색
    public ArrayList<UIVO> selectMajor(String major) {
        ArrayList<UIVO> voList = new ArrayList<UIVO>();
        String sql = "select * from TBL_STUDENT where MAJOR Like '%" + major + "%'";
        SQLiteDatabase db = this.getReadableDatabase();
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
    public boolean insertStudent(UIVO vo) {
        boolean result = false;
        String SNO = vo.getSNO();
        String SNAME = vo.getSNAME();
        int SYEAR = vo.getSYEAR();
        String GENDER = vo.getGENDER();
        String MAJOR = vo.getMAJOR();
        int SCORE = vo.getSCORE();

        SQLiteDatabase db = null;
        try {
            String sql = "insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)" +
                    "     values('" + SNO + "', '" + SNAME + "', " + SYEAR + ", " +
                    "'" + GENDER + "', '" + MAJOR + "', " + SCORE + ")";
            db = this.getWritableDatabase();
            db.execSQL(sql);
            Log.d("tag", "Success insert.");
            result = true;
        } catch (Exception e) {
            Log.d("tag", "Fail insert.");
        } finally {
            db.close();
        }
        return result;
    }

    // 수정하기
    public boolean updateStudent(UIVO vo) {
        boolean result = false;
        String SNO = vo.getSNO();
        String SNAME = vo.getSNAME();
        int SYEAR = vo.getSYEAR();
        String GENDER = vo.getGENDER();
        String MAJOR = vo.getMAJOR();
        int SCORE = vo.getSCORE();

        String sql = "update TBL_STUDENT" +
                "     set SNAME = '" + SNAME + "', SYEAR = " + SYEAR + ", " +
                "     GENDER = '" + GENDER + "', MAJOR = '" + MAJOR + "', " +
                "     SCORE = " + SCORE + " where SNO = '" + SNO + "'";
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.execSQL(sql);
            result = true;
            Log.d("tag", "업데이트 성공");
        } catch (Exception e) {
            Log.d("tag", "업데이트 실패");
        } finally {
            db.close();
        }

        return result;
    }

    // 삭제하기
    public boolean deleteStudent(String sno) {
        boolean result = false;

        String sql = "delete from TBL_STUDENT where SNO = '"+sno+"'";
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.execSQL(sql);
            result = true;
            Log.d("tag", "삭제 성공");
        } catch (Exception e) {
            Log.d("tag", "삭제 실패");
        } finally {
            db.close();
        }

        return result;
    }
}
