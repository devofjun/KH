package com.kh.paintexself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    class MyGraphicView extends View {

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();

            // 아주 굵은 선
            paint.setStrokeWidth(40);
            canvas.drawLine(50,50, 300,50, paint);

            // 끝이 굵은 선
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 120, 300, 120, paint);

            // 색이 채워진 타원
            paint.setStyle(Paint.Style.FILL);
            canvas.drawOval(new RectF(100, 200, 100+130, 200+70), paint);

            // 색이 채워진 호
            RectF rf = new RectF(50, 250, 50+100, 250+100);
            canvas.drawArc(rf, 30, 120, true, paint);

            // 파란색 사각형
            paint.setColor(Color.BLUE);
            Rect rect = new Rect(50, 380, 50+100, 380+100);
            canvas.drawRect(rect, paint);

            // 투명한 사각형
            paint.setColor(0x88ff0000);
            rect.set(80,410,80+100,410+100);
            canvas.drawRect(rect, paint);
        }
    }
}