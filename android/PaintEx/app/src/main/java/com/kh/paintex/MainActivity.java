package com.kh.paintex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    // 뷰 내부클래스
    class  MyGraphicView extends View {

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // 배경색을 채운다.
            setBackgroundColor(Color.YELLOW);
            // 그리기위한 붓을 생성한다.
            Paint paint = new Paint();
            // 곡선을 부드럽게 처리한다.
            paint.setAntiAlias(true);
            // 붓의 색을 지정한다.
            paint.setColor(Color.GREEN);
            // 10,10에서 300,10까지 paint라는 붓으로 선을 그린다.
            canvas.drawLine(10,10, 300, 10, paint);

            // 굵은 파란선 그리기
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(5);
            canvas.drawLine(10,20,300,20,paint);

            // setStrokeWidth을 0으로 하면 선이 얇게나옴.
            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);
            canvas.drawLine(10,30,300,30, paint);

            // 색을 채운 사각형
            paint.setStyle(Paint.Style.FILL);
            Rect rect1 = new Rect(10,50,10+100,50+100);
            canvas.drawRect(rect1, paint);

            // 색을 채우지 않는 사각형
            paint.setStyle(Paint.Style.STROKE);
            Rect rect2 = new Rect(130,50,130+100,50+100);
            canvas.drawRect(rect2, paint);

            // 둥근 사각형
            RectF rectF = new RectF(250, 50, 250+100,50+100);
            canvas.drawRoundRect(rectF,30,30,paint);

            // 원그리기(중심점, 반지름)
            canvas.drawCircle(60, 220, 50, paint);

            // 패스(경로) 그리기
            Path p = new Path(); // android.graphics.Path
            p.moveTo(10, 290);
            p.lineTo(10+50, 290+50);
            p.lineTo(10+100, 290);
            p.lineTo(10+150, 290+50);
            p.lineTo(10+200, 290);
            canvas.drawPath(p, paint);

            // 글자 그리기
            canvas.drawText("안녕하세요", 10, 390, paint);
        }
    }
        // onDraw
        // 배경색
        // 붓 색 = Paint paint = new Paint();
}