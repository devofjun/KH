package com.example.ui_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    RadioButton rdoNameSch;
    RadioButton rdoMajorSch;
    EditText edtSch;
    ListView listView;
    Button btnCreate, btnSearch;
    // 메세지
    Toast toast = null;
    // 검색된 결과를 보여줄 리스트
    ArrayList<UIVO> voList = new ArrayList<>();
    // 데이터베이스
    UIDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        rdoNameSch = findViewById(R.id.rdoNameSch);
        rdoMajorSch = findViewById(R.id.rdoMajorSch);
        edtSch = findViewById(R.id.edtSch);
        listView = findViewById(R.id.listView);
        btnSearch = findViewById(R.id.btnSearch);
        btnCreate = findViewById(R.id.btnCreate);

        btnSearch.setOnClickListener(this);
        btnCreate.setOnClickListener(this);

        dao = UIDAO.getInstance(MainActivity.this, "StudentDB", null, 1);
        voList = dao.selectAll();

        // 리스트뷰에 셀을 어댑터를 통해서 아이템을 추가한다.
        listView.setAdapter(new MyListAdaper(this, R.layout.cell_view, voList));
        // 각각의 아이템에 다이얼로그를 띄우기 위해 리스너을 추가한다.
        listView.setOnItemClickListener(this);
    }

    // 입력 데이터 체크
    private boolean valueCheck(String sno, String sname, String syear,
                               String gender, String major, String score) {
        // 학번 값 체크
        if(sno.trim().equals("")){ // 학번이 비었음
            toast.setText("학번을 입력해주세요.");
            toast.show();
            return false;
        }
        // 이름 값 체크
        if (sname.trim().equals("")) { // 이름이 비었음
            //toast.cancel();
            toast.setText("이름을 입력해주세요.");
            toast.show();
            return false;
        }// 이름도 최대 몇자까지인지 정해주기

        // 학년 값 체크
        try {
            int year = Integer.parseInt(syear);
            if (year <= 0 || year >= 10) { //1~9사이의 값이 아닐때
                toast.setText("학년이 1~9값인지 확인하세요.");
                toast.show();
                return false;
            }
        } catch (Exception e) { // 숫자 변환이 안됐을때
            //toast.cancel();
            toast.setText("학년이 1~9값인지 확인하세요.");
            toast.show();
            return false;
        }

        // 성별 값 체크
        if (gender.trim().equals("")) { // 성별이 비었음
            //toast.cancel();
            toast.setText("성별을 선택해주세요.");
            toast.show();
            return false;
        }

        // 전공 값 체크
        if (major.trim().equals("")) { // 전공이 비었음
            //toast.cancel();
            toast.setText("전공을 입력해주세요.");
            toast.show();
            return false;
        } // 전공도 최대 몇자까지 가능한지 체크해주기

        // 점수 값 체크
        try {
            int i_score = Integer.parseInt(score);
            if (i_score < 0 || i_score > 100) { // 점수가 0~100 사이의 값이 아닐때
                toast.setText("점수(0~100)를 입력하세요.");
                toast.show();
                return false;
            }
        } catch (Exception e) {
            //toast.cancel();
            toast.setText("점수(0~100)를 입력하세요.");
            toast.show();
            return false;
        }
        return true;
    }

    // 버튼 클릭 이벤트 (검색, 등록하기)
    @Override
    public void onClick(View v) {
        boolean check = false;
        if (v == btnSearch) { // 검색 버튼
            String search = edtSch.getText().toString();
            if (search.trim().equals("")) { // 검색창에 아무 입력이 없다면 전체 검색
                voList = dao.selectAll();
            } else {
                if (rdoNameSch.isChecked()) { // 이름으로 검색
                    voList = dao.selectName(search);
                } else if (rdoMajorSch.isChecked()) { // 전공으로 검색
                    voList = dao.selectMajor(search);
                }
            }
            listView.setAdapter(new MyListAdaper(MainActivity.this, R.layout.cell_view, voList));
            listView.setOnItemClickListener(MainActivity.this);

        } else if (v == btnCreate) { // 등록하기 버튼
            // 다이얼로그 전개자
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_regist, null);
            // 다이얼로그 생성
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setIcon(R.mipmap.ic_launcher);
            dialog.setTitle("학생등록");
            dialog.setView(dialogView);

            // 전개될 다이얼로그 컨텐츠 id
            EditText rSNO = dialogView.findViewById(R.id.rSno);
            EditText rSNAME = dialogView.findViewById(R.id.rSname);
            EditText rSYEAR = dialogView.findViewById(R.id.rSyear);
            RadioButton rMAN = dialogView.findViewById(R.id.rMan);
            RadioButton rWOMAN = dialogView.findViewById(R.id.rWoman);
            EditText rMAJOR = dialogView.findViewById(R.id.rMajor);
            EditText rSCORE = dialogView.findViewById(R.id.rScore);
            Button rBtnReg = dialogView.findViewById(R.id.rBtnReg);
            // 등록하기 버튼 클릭
            rBtnReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //

                    //
                }
            });
            dialog.setPositiveButton("등록하기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("tag", "등록하기 눌림");
                    // 입력된 데이터
                    String SNO = rSNO.getText().toString();
                    String SNAME = rSNAME.getText().toString();
                    String MAJOR = rMAJOR.getText().toString();
                    String SYEAR = rSYEAR.getText().toString();
                    String SCORE = rSCORE.getText().toString();
                    String GENDER = "";
                    if (rMAN.isChecked()) {
                        GENDER = "남";
                    } else if (rWOMAN.isChecked()) {
                        GENDER = "여";
                    }
                    // 입력 데이터 확인
                    boolean result = valueCheck(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);
                    // 올바른 입력이라면 데이터베이스에 추가하고 리스트를 다시 연다.
                    if (result) {
                        int iSYEAR = Integer.parseInt(SYEAR);
                        int iSCORE = Integer.parseInt(SCORE);
                        UIVO vo = new UIVO(SNO, SNAME, iSYEAR, GENDER, MAJOR, iSCORE);
                        boolean inResult = dao.insertStudent(vo);
                        if(inResult){
                            toast.setText("등록되었습니다.");
                            toast.show();
                            // 리스트 다시 그리기
                            voList = dao.selectAll();
                            listView.setAdapter(new MyListAdaper(MainActivity.this, R.layout.cell_view, voList));
                            listView.setOnItemClickListener(MainActivity.this);
                        } else {
                            toast.setText("등록에 실패했습니다.");
                            toast.show();
                        }

                    }

                }
            });

            dialog.setNeutralButton("닫기", null);
            dialog.show();


        }
    }

    // 리스트뷰 아이템 클릭 이벤트
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
        // 클릭한 아이템에 데이터 넣어주기
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

        // 다이얼로그 생성
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle(voList.get(position).getSNAME());
        dialog.setView(dialogView);
        dialog.setPositiveButton("닫기", null);
        dialog.show();


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
                String sno = sSno.getText().toString();
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
                boolean check = valueCheck(sno, sname, syear, gender, major, score);
                Log.d("tag", "valueCheck:" + check);
                if (check) { // 데이터베이스 반영
                    // vo에 담을 변수
                    String SNO = sSno.getText().toString();
                    String SNAME = sname;
                    int SYEAR = Integer.parseInt(syear);
                    String GENDER = gender;
                    String MAJOR = major;
                    int SCORE = Integer.parseInt(score);
                    // 변경된 데이터를 가지고 있는 vo
                    UIVO changeVo = new UIVO(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);
                    //Log.d("tag", "changeVo: " + changeVo);
                    boolean result = dao.updateStudent(changeVo);
                    if(result){
                        toast.setText("수정 성공");
                        toast.show();
                    } else {
                        toast.setText("수정 실패");
                        toast.show();
                    }
                    // 리스트 다시 그리기
                    voList = dao.selectAll();
                    listView.setAdapter(new MyListAdaper(MainActivity.this, R.layout.cell_view, voList));
                    listView.setOnItemClickListener(MainActivity.this);
                }
            }
        });
        // 삭제하기 버튼 클릭
        sBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("tag","삭제");
                sBtnDeleteFin.setEnabled(true);
            }
        });
        // 삭제완료 버튼 클릭
        sBtnDeleteFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("tag","삭제완료");
                String sno = sSno.getText().toString();
                boolean result = dao.deleteStudent(sno);
                if(result){
                    toast.setText("삭제 성공");
                    toast.show();

                } else {
                    toast.setText("삭제 실패");
                    toast.show();
                }
                // 리스트 다시 그리기
                voList = dao.selectAll();
                listView.setAdapter(new MyListAdaper(MainActivity.this, R.layout.cell_view, voList));
                listView.setOnItemClickListener(MainActivity.this);
            }
        });

    }



}
