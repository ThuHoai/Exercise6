package com.example.hoaiktt.exercise6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hoaiktt on 7/26/2017.
 */

public class CustomView extends View {
    private Paint mDrawPaint;
    private Paint mColorPaint;
    private static String color = "#FFEDA514";

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpDrawing();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DrawShapeView(canvas,180,250);
    }

    public void setUpDrawing() {
        mDrawPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDrawPaint.setStyle(Paint.Style.STROKE);
        mDrawPaint.setColor(Color.parseColor(color));
        mDrawPaint.setStrokeWidth(5);
        mColorPaint = new Paint();
        mColorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mColorPaint.setColor(Color.RED);
    }

    public void DrawShapeView(Canvas drawBitmap, float viewHieght, float viewWidth){
        float left = (getWidth()-viewWidth)/2.0f;
        float top = (getHeight()-viewHieght)/2.0f;
        drawBitmap.drawRect(left,top,left+viewWidth,top+viewHieght,mColorPaint);
        drawBitmap.drawLine(left,top,left+viewWidth,top+viewHieght,mDrawPaint);
        drawBitmap.drawLine(left,top+viewHieght,left+viewWidth,top,mDrawPaint);
        drawBitmap.drawLine(left,(top+viewHieght/2),left+viewWidth,(top+viewHieght/2),mDrawPaint);
        drawBitmap.drawLine((left+viewWidth/2),top,(left+viewWidth/2), top+viewHieght,mDrawPaint);
    }

  /*  @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                mDrawPath.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                mDrawPath.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:
                mDrawPath.moveTo(touchX,touchY);
                break;
            default:
                return false;

        }
        return super.onTouchEvent(event);
    }*/
}
