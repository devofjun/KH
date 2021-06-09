package com.example.ui_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
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
    // 알림 메세지
    AlertDialog.Builder msg;

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
        listView.setAdapter(new MyListAdater(this, R.layout.cell_view, voList));
        // 각각의 아이템에 다이얼로그를 띄우기 위해 리스너을 추가한다.
        listView.setOnItemClickListener(this);

        toast = Toast.makeText(this.getApplicationContext(), "", Toast.LENGTH_SHORT);

        // 알림 메세지 설정
        msg = new AlertDialog.Builder(MainActivity.this);
        msg.setTitle("알림");
        msg.setMessage("알림 내용");
        msg.setIcon(R.mipmap.ic_launcher);
        // msg.show();
    }

    // ==============================
    // 메인액티비티의 버튼 - 검색, 등록하기
    // ==============================
    @Override
    public void onClick(View v) {
        boolean check = false;
        switch (v.getId()) {
            // ============
            // "검색" 버튼
            // ============
            case R.id.btnSearch:
                String search = edtSch.getText().toString();
                // 검색창에 아무 입력이 없다면 전체 검색
                if (search.trim().equals("")) {
                    voList = dao.selectAll();
                } else {
                    // 이름으로 검색
                    if (rdoNameSch.isChecked()) {
                        voList = dao.selectName(search);
                    }
                    // 전공으로 검색
                    else if (rdoMajorSch.isChecked()) {
                        voList = dao.selectMajor(search);
                    }
                }
                listView.setAdapter(new MyListAdater(MainActivity.this, R.layout.cell_view, voList));
                listView.setOnItemClickListener(MainActivity.this);
                toast.setText("검색완료");
                toast.show();
                break;
            // ===================================================
            // 등록 -> "새로운 학생 추가하기" 버튼 -> 학생 등록 다이얼로그
            // ===================================================
            case R.id.btnCreate:
                // 다이얼로그에 그려질 뷰 전개자
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_regist, null);
                // *다이얼로그 생성*
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(dialogView)
                        .setTitle("학생등록")
                        .setPositiveButton("등록하기", null)
                        .setNeutralButton("닫기", null)
                        .create();
                // 전개될 다이얼로그 위젯 id 매칭
                EditText rSno = dialogView.findViewById(R.id.rSno);
                EditText rSname = dialogView.findViewById(R.id.rSname);
                EditText rSyear = dialogView.findViewById(R.id.rSyear);
                RadioButton rMan = dialogView.findViewById(R.id.rMan);
                RadioButton rWoman = dialogView.findViewById(R.id.rWoman);
                EditText rMajor = dialogView.findViewById(R.id.rMajor);
                EditText rScore = dialogView.findViewById(R.id.rScore);
                CheckBox cbxRemove = dialogView.findViewById(R.id.cbxRemove);
                Button rBtnContinue = dialogView.findViewById(R.id.rBtnContinue);

                // "등록 계속하기" 버튼 클릭
                rBtnContinue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 입력된 데이터
                        String SNO = rSno.getText().toString();
                        String SNAME = rSname.getText().toString();
                        String SYEAR = rSyear.getText().toString();
                        String MAJOR = rMajor.getText().toString();
                        String SCORE = rScore.getText().toString();
                        String GENDER = "";
                        if (rMan.isChecked()) {
                            GENDER = "남";
                        } else if (rWoman.isChecked()) {
                            GENDER = "여";
                        }
                        // *입력 데이터 확인*
                        boolean result = valueCheck(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);
                        // 올바른 입력이라면 데이터베이스에 추가하고 리스트를 다시 연다.
                        if (result) {
                            int iSYEAR = Integer.parseInt(SYEAR);
                            int iSCORE = Integer.parseInt(SCORE);
                            UIVO vo = new UIVO(SNO, SNAME, iSYEAR, GENDER, MAJOR, iSCORE);
                            // *학생정보 insert*
                            boolean inResult = dao.insertStudent(vo);
                            if (inResult) {
                                msg.setMessage("등록되었습니다.");
                                msg.show();
                                // 리스트 다시 그리기
                                voList = dao.selectAll();
                                listView.setAdapter(new MyListAdater(MainActivity.this, R.layout.cell_view, voList));
                                listView.setOnItemClickListener(MainActivity.this);

                                if(cbxRemove.isChecked()){
                                    rSno.setText("");
                                    rSname.setText("");
                                    rSyear.setText("");
                                    rMajor.setText("");
                                    rScore.setText("");
                                    rMan.setChecked(false);
                                    rWoman.setChecked(false);
                                }
                            } else {
                                msg.setMessage("등록에 실패했습니다.");
                                msg.show();
                            }

                        }
                    }
                });

                // *"등록하기"버튼 동작구현*
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        // "등록하기" 버튼
                        Button registButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                        registButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //msg.setMessage("testing");
                                //msg.show();
                                //dialog.dismiss();
                                // 입력된 데이터
                                String SNO = rSno.getText().toString();
                                String SNAME = rSname.getText().toString();
                                String SYEAR = rSyear.getText().toString();
                                String MAJOR = rMajor.getText().toString();
                                String SCORE = rScore.getText().toString();
                                String GENDER = "";
                                if (rMan.isChecked()) {
                                    GENDER = "남";
                                } else if (rWoman.isChecked()) {
                                    GENDER = "여";
                                }
                                // *입력 데이터 확인*
                                boolean result = valueCheck(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE);
                                // 올바른 입력이라면 데이터베이스에 추가하고 리스트를 다시 연다.
                                if (result) {
                                    int iSYEAR = Integer.parseInt(SYEAR);
                                    int iSCORE = Integer.parseInt(SCORE);
                                    UIVO vo = new UIVO(SNO, SNAME, iSYEAR, GENDER, MAJOR, iSCORE);
                                    // *학생정보 insert*
                                    boolean inResult = dao.insertStudent(vo);
                                    if (inResult) {
                                        msg.setMessage("등록되었습니다.");
                                        msg.show();
                                        // 리스트 다시 그리기
                                        voList = dao.selectAll();
                                        listView.setAdapter(new MyListAdater(MainActivity.this, R.layout.cell_view, voList));
                                        listView.setOnItemClickListener(MainActivity.this);
                                        dialog.dismiss();
                                    } else {
                                        msg.setMessage("등록에 실패했습니다.");
                                        msg.show();
                                    }

                                }
                            }
                        });
                    }
                });
                dialog.show();
                break;
        }
    }

    // ======================================================
    // 리스트의 아이템 클릭 했을 때 -> "학생 상세 정보" 다이얼로그 띄움
    // ======================================================
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 다이얼로그 전개자
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_modify, null);
        // 전개될 다이얼로그의 위젯 id매칭
        EditText mSno = dialogView.findViewById(R.id.mSno);
        EditText mSname = dialogView.findViewById(R.id.mSname);
        EditText mSyear = dialogView.findViewById(R.id.mSyear);
        RadioButton mMan = dialogView.findViewById(R.id.mMan);
        RadioButton mWoman = dialogView.findViewById(R.id.mWoman);
        EditText mMajor = dialogView.findViewById(R.id.mMajor);
        EditText mScore = dialogView.findViewById(R.id.mScore);

        // 다이얼로그에 학생 정보 삽입
        mSno.setText(voList.get(position).getSNO());
        mSname.setText(voList.get(position).getSNAME());
        mSyear.setText(String.valueOf(voList.get(position).getSYEAR()));
        mMajor.setText(voList.get(position).getMAJOR());
        mScore.setText(String.valueOf(voList.get(position).getSCORE()));
        String gender = voList.get(position).getGENDER();
        if (gender.equals("남")) {
            mWoman.setChecked(false);
            mMan.setChecked(true);
        } else if (gender.equals("여")) {
            mMan.setChecked(false);
            mWoman.setChecked(true);
        }
        // 다이얼로그 생성, 띄우기
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(voList.get(position).getSNAME())
                .setView(dialogView)
                .setPositiveButton("수정하기", null)
                .setNegativeButton("삭제하기", null)
                .setNeutralButton("닫기", null)
                .create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                // "수정하기" 버튼
                Button modifyButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                modifyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //msg.setMessage("testing");
                        //msg.show();
                        //dialog.dismiss();
                        // 입력된 데이터
                        String sno = mSno.getText().toString();
                        String sname = mSname.getText().toString();
                        String major = mMajor.getText().toString();
                        String syear = mSyear.getText().toString();
                        String score = mScore.getText().toString();
                        String gender = "";
                        if (mMan.isChecked()) {
                            gender = "남";
                        } else if (mWoman.isChecked()) {
                            gender = "여";
                        }
                        // *입력 데이터 확인*
                        boolean result = valueCheck(null, sname, syear, gender, major, score);
                        // 올바른 입력이라면 데이터베이스에 추가하고 리스트를 다시 연다.
                        if (result) {
                            int intSYear = Integer.parseInt(syear);
                            int intScore = Integer.parseInt(score);
                            UIVO vo = new UIVO(sno, sname, intSYear, gender, major, intScore);
                            // *학생정보 update*
                            boolean upResult = dao.updateStudent(vo);
                            if (upResult) {
                                msg.setMessage("수정 되었습니다.");
                                msg.show();
                                // 리스트 다시 그리기
                                voList = dao.selectAll();
                                listView.setAdapter(new MyListAdater(MainActivity.this, R.layout.cell_view, voList));
                                listView.setOnItemClickListener(MainActivity.this);
                                // 다이얼로그 창 닫기
                                dialog.dismiss();
                            } else {
                                msg.setMessage("수정 실패했습니다.");
                                msg.show();
                            }

                        }
                    }
                });
                // *삭제하기*
                Button deleteButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sno = mSno.getText().toString();
                        boolean check = !(dao.checkSNO(sno));
                        if(check){
                            boolean delResult = dao.deleteStudent(sno);
                            if(delResult){
                                msg.setMessage("삭제 되었습니다.");
                                msg.show();
                                // 리스트 다시 그리기
                                voList = dao.selectAll();
                                listView.setAdapter(new MyListAdater(MainActivity.this, R.layout.cell_view, voList));
                                listView.setOnItemClickListener(MainActivity.this);
                                // 다이얼로그 창 닫기
                                dialog.dismiss();
                            } else {
                                msg.setMessage("삭제 실패했습니다.");
                                msg.show();
                            }
                        } else {
                            msg.setMessage("유효하지 않은 학번입니다.");
                            msg.show();
                        }
                    }
                });
            }
        });
        dialog.show();
    }

    // =================
    // 입력 데이터 체크
    // =================
    private boolean valueCheck(String sno, String sname, String syear,
                               String gender, String major, String score) {

        String snoMsg = "1. 학번은 공백을 허용하지 않음\n" + "2. 학번은 8자리 입력해야함\n" + "3. 학번은 중복값을 허용하지 않음";
        String snameMsg = "1. 이름은 공백을 허용하지 않음\n" + "2. 이름은 3자리까지 입력가능함.";
        String syearMsg = "1. 학년은 공백을 허용하지 않음\n" + "2. 학년은 문자를 입력 할 수 없음\n" + "3. 학년은 1부터4까지의 숫자를 입력할수있음";
        String genderMsg = "1. 성별은 꼭 선택해야함";
        String majorMsg = "1. 전공은 공백을 허용하지 않음\n" + "2. 전공을 3자리까지 입력가능함";
        String scoreMsg = "1. 점수는 공백을 허용하지 않음\n" + "2. 점수는 문자를 입력 할 수 없음\n" + "3. 점수는 0부터 100까지의 수를 입력 할 수 있음";

        // *학번 값 체크*
        if (sno != null) {
            msg.setMessage(snoMsg);
            if (sno.trim().equals("")) {
                toast.setText("학번을 입력해주세요");
                toast.show();
                msg.show();
                return false;
            } else if (sno.replace(" ","").length() != sno.length()) {
                toast.setText("학번에 공백은 넣을 수 없습니다.");
                toast.show();
                msg.show();
                return false;
            } else if (sno.length() != 8) {
                toast.setText("학번은 8자리입니다.");
                toast.show();
                msg.show();
                return false;
            } else if (!(dao.checkSNO(sno))) {
                toast.setText("사용중인 학번입니다.");
                toast.show();
                msg.show();
                return false;
            }
        }

        // *이름 값 체크*
        msg.setMessage(snameMsg);
        if (sname.trim().equals("")) {
            toast.setText("이름을 입력해주세요.");
            toast.show();
            msg.show();
            return false;
        } else if (sname.replace(" ","").length() != sname.length()) {
            toast.setText("이름에 공백은 넣을 수 없습니다.");
            toast.show();
            msg.show();
            return false;
        } else if (!(sname.length() <= 3)) { // 이름은 세자리까지 허용됨
            toast.setText("이름은 최대 3글자입니다.");
            toast.show();
            msg.show();
            return false;
        }

        // *학년 값 체크*
        msg.setMessage(syearMsg);
        try {
            int intYear = Integer.parseInt(syear);
            if (!(intYear >= 1 && intYear <= 4)) {
                toast.setText("학년은 1~4로 입력해주세요.");
                toast.show();
                msg.show();
                return false;
            }
        } catch (Exception e) {
            toast.setText("학년은 숫자로 입력해주세요.");
            toast.show();
            msg.show();
            return false;
        }

        // *성별값 체크*
        msg.setMessage(genderMsg);
        if (gender.trim().equals("")) {
            toast.setText("성별을 선택해주세요.");
            toast.show();
            msg.show();
            return false;
        } else if (gender.replace(" ","").length() != gender.length()) {
            toast.setText("성별을 선택해주세요.");
            toast.show();
            msg.show();
            return false;
        } else if (!(gender.equals("남") || gender.equals("여"))) {
            toast.setText("성별을 선택해주세요.");
            toast.show();
            msg.show();
            return false;
        }

        // *전공 값 체크*
        msg.setMessage(majorMsg);
        if (major.trim().equals("")) {
            toast.setText("전공을 입력해주세요.");
            toast.show();
            msg.show();
            return false;
        } else if (major.replace(" ","").length() != major.length()) {
            toast.setText("전공에 공백은 넣을수 없습니다.");
            toast.show();
            msg.show();
            return false;
        } else if (!(major.length() <= 3)) {
            toast.setText("전공은 최대 세글자 입니다.");
            toast.show();
            msg.show();
            return false;
        }

        // *점수 값 체크*
        msg.setMessage(scoreMsg);
        try {
            int intScore = Integer.parseInt(score);
            if (intScore < 0 || intScore > 100) {
                toast.setText("점수는 0~100까지의 수를 입력해주세요.");
                toast.show();
                msg.show();
                return false;
            }
        } catch (Exception e) {
            toast.setText("숫자만 입력해주세요.");
            toast.show();
            msg.show();
            return false;
        }
        msg.setMessage("");
        return true;
    }

}
