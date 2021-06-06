package com.example.ui_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioButton rdoNameSch;
    RadioButton rdoMajorSch;
    EditText edtSch;
    ListView listView;
    Button btnCreate;

    Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

    ArrayList<UIVO> voList = new ArrayList<>();

    UIVO testvo1 = new UIVO("20151065", "정병준", 2, "남", "컴공", 98);
    UIVO testvo2 = new UIVO("20151066", "누굴까", 1, "여", "화학", 45);
    UIVO testvo3 = new UIVO("20151067", "누구니", 3, "남", "전자", 64);
    UIVO testvo4 = new UIVO("20151068", "아무개", 4, "여", "물리", 34);
    UIVO testvo5 = new UIVO("20151069", "나란다", 2, "남", "음악", 75);
    UIVO testvo6 = new UIVO("20151065", "정병준", 2, "남", "컴공", 98);
    UIVO testvo7 = new UIVO("20151066", "누굴까", 1, "여", "화학", 45);
    UIVO testvo8 = new UIVO("20151067", "누구니", 3, "남", "전자", 64);
    UIVO testvo9 = new UIVO("20151068", "아무개", 4, "여", "물리", 34);
    UIVO testvo10 = new UIVO("20151069", "나란다", 2, "남", "음악", 75);
    UIVO testvo11 = new UIVO("20151065", "정병준", 2, "남", "컴공", 98);
    UIVO testvo12 = new UIVO("20151066", "누굴까", 1, "여", "화학", 45);
    UIVO testvo13 = new UIVO("20151067", "누구니", 3, "남", "전자", 64);
    UIVO testvo14 = new UIVO("20151068", "아무개", 4, "여", "물리", 34);
    UIVO testvo15 = new UIVO("20151069", "나란다", 2, "남", "음악", 75);
    UIVO testvo16 = new UIVO("20151065", "정병준", 2, "남", "컴공", 98);
    UIVO testvo17 = new UIVO("20151066", "누굴까", 1, "여", "화학", 45);
    UIVO testvo18 = new UIVO("20151067", "누구니", 3, "남", "전자", 64);
    UIVO testvo19 = new UIVO("20151068", "아무개", 4, "여", "물리", 34);
    UIVO testvo20 = new UIVO("20151069", "나란다", 2, "남", "음악", 75);
    UIDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoNameSch = findViewById(R.id.rdoNameSch);
        rdoMajorSch = findViewById(R.id.rdoMajorSch);
        edtSch = findViewById(R.id.edtSch);
        listView = findViewById(R.id.listView);
        btnCreate = findViewById(R.id.btnCreate);

        dao = UIDAO.getInstance(MainActivity.this, "StudentDB", null, 1);

        voList.add(testvo1);
        voList.add(testvo2);
        voList.add(testvo3);
        voList.add(testvo4);
        voList.add(testvo5);
        voList.add(testvo6);
        voList.add(testvo7);
        voList.add(testvo8);
        voList.add(testvo9);
        voList.add(testvo10);
        voList.add(testvo11);
        voList.add(testvo12);
        voList.add(testvo13);
        voList.add(testvo14);
        voList.add(testvo15);
        voList.add(testvo16);
        voList.add(testvo17);
        voList.add(testvo18);
        voList.add(testvo19);
        voList.add(testvo20);

        // 리스트뷰에 셀을 어댑터를 통해서 아이템을 추가한다.
        listView.setAdapter(new MyListAdaper(this, R.layout.cell_view, voList));
        // 각각의 아이템에 다이얼로그를 띄우기 위해 리스너을 추가한다.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 다이얼로그 전개자
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_student, null);
                // 전개될 다이얼로그 컨텐츠 id
                EditText sSno = dialogView.findViewById(R.id.sSno);
                EditText sSname = dialogView.findViewById(R.id.sSname);
                EditText sSyear = dialogView.findViewById(R.id.sSyear);
                RadioButton sMan = dialogView.findViewById(R.id.sMan);
                RadioButton sWoman = dialogView.findViewById(R.id.sWoman);
                EditText sMajor = dialogView.findViewById(R.id.sMajor);
                EditText sScore = dialogView.findViewById(R.id.sScore);
                Button sBtnModify = dialogView.findViewById(R.id.sBtnModify);
                Button sBtnModifyFin = dialogView.findViewById(R.id.sBtnModifyFin);
                Button sBtnDelete = dialogView.findViewById(R.id.sBtnDelete);
                Button sBtnDeleteFin = dialogView.findViewById(R.id.sBtnDeleteFin);
                // 클릭한 아이템의 데이터 넣어주기
                sSno.setText(voList.get(position).getSNO());
                sSname.setText(voList.get(position).getSNAME());
                sSyear.setText(String.valueOf(voList.get(position).getSYEAR()));
                sMajor.setText(voList.get(position).getMAJOR());
                sScore.setText(String.valueOf(voList.get(position).getSCORE()));
                String gender = voList.get(position).getGENDER();
                if (gender.equals("남")) {
                    sWoman.setChecked(false);
                    sMan.setChecked(true);
                } else if (gender.equals("여")) {
                    sMan.setChecked(false);
                    sWoman.setChecked(true);
                }
                // 수정하기 버튼 클릭 이벤트
                sBtnModify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.d("tag","수정");
                        sSname.setEnabled(true);
                        sSyear.setEnabled(true);
                        sMajor.setEnabled(true);
                        sScore.setEnabled(true);
                        sWoman.setEnabled(true);
                        sMan.setEnabled(true);
                        sBtnModifyFin.setEnabled(true);
                    }
                });
                // 수정완료 버튼 클릭 이벤트
                sBtnModifyFin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.d("tag","수정완료");
                        // 입력값 받아오기
                        String sname = sSname.getText().toString();
                        String syear = sSyear.getText().toString();
                        String gender;
                        if (sMan.isChecked()) {
                            gender = "남";
                        } else if (sWoman.isChecked()) {
                            gender = "여";
                        } else {
                            gender = "";
                        }
                        String major = sMajor.getText().toString();
                        String score = sScore.getText().toString();
                        // 입력값 체크하기
                        boolean check = valueCheck(sname, syear, gender, major, score);

                        if (check) { // 데이터베이스 반영
                            Log.d("tag", "valueCheck:true");
                            // vo에 담을 변수
                            String SNO = sSno.getText().toString();
                            String SNAME = sname;
                            int SYEAR = Integer.parseInt(syear);
                            String GENDER = gender;
                            String MAJOR = major;
                            int SCORE = Integer.parseInt(score);
                            // 변경된 데이터를 가지고 있는 vo
                            UIVO changeVo = new UIVO(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);

                        } else { // 대기
                            Log.d("tag", "valueCheck:false");
                        }

                    }
                });
                // 삭제하기 버튼 클릭 이벤트
                sBtnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.d("tag","삭제");
                        sBtnDeleteFin.setEnabled(true);
                    }
                });
                // 삭제완료 버튼 클릭 이벤트
                sBtnDeleteFin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.d("tag","삭제완료");
                    }
                });

                // 다이얼로그 생성
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(voList.get(position).getSNAME());
                dialog.setView(dialogView);
                dialog.setPositiveButton("닫기", null);
                dialog.show();
            }
        });
    }

    private boolean valueCheck(String sname, String syear,
                               String gender, String major, String score) {

        if (sname.trim().equals("")) { // 이름이 비었음
            toast.cancel();
            toast.setText("이름을 입력해주세요.");
            toast.show();
            return false;
        }
        if (syear.trim().equals("")) { // 학년이 비었음
            toast.cancel();
            toast.setText("학년을 입력해주세요.");
            toast.show();
            return false;
        } //else if() 학년 값 체크

        if (gender.trim().equals("")) { // 성별이 비었음
            toast.cancel();
            toast.setText("성별을 선택해주세요.");
            toast.show();
            return false;
        }
        if (major.trim().equals("")) { // 전공이 비었음
            toast.cancel();
            toast.setText("전공을 입력해주세요.");
            toast.show();
            return false;
        }
        if (score.trim().equals("")) { // 점수이 비었음
            toast.cancel();
            toast.setText("점수를 입력해주세요.");
            toast.show();
            return false;
        }
        return false;
    }
}