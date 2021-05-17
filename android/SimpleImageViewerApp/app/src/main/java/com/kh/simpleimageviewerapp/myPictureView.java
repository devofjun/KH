package com.kh.simpleimageviewerapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {
    String filePath;

    // java 코드로 생성시
    public myPictureView(Context context) {
        super(context);
    }
    // XML 이용해서 생성시
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    // 스윙의 paintComponent(Graphics g) - g: 붓

    @Override
    protected void onDraw(Canvas canvas) { // canvas : 도화지
        super.onDraw(canvas);
        //filePath = "/sdcard/Pictures/cat.jpg";
        if(filePath == null){
            return;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        // 비트맵 이미지 그리기 - (0,0)의 위치에 그림
        canvas.drawBitmap(bitmap,0,0,null);
        // 이미지는 메모리를 많이 차지한다.
        bitmap.recycle();
    }
}
