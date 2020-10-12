package com.u3192633.centralexecutivefunctioncapturetool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SimpleDrawingView extends View {

    // setup initial color
    private final int paintColor = Color.BLACK;
    // defines paint and canvas
    private Paint drawPaint;

    // Lets draw the pattern
    @Override
    protected void onDraw(Canvas canvas) {
        // Row 1 of the pattern
        canvas.drawLine(150,100,300,100, drawPaint);
        canvas.drawLine(400,100,550,100, drawPaint);
        canvas.drawLine(650,100,800,100, drawPaint);

        canvas.drawLine(100,150,100,300, drawPaint);
        canvas.drawLine(350,150,350,300, drawPaint);
        canvas.drawLine(600,150,600,300, drawPaint);
        canvas.drawLine(850,150,850,300, drawPaint);

        // Row 2 of the pattern
        canvas.drawLine(150,350,300,350, drawPaint);
        canvas.drawLine(400,350,550,350, drawPaint);
        canvas.drawLine(650,350,800,350, drawPaint);

        canvas.drawLine(100,400,100,550, drawPaint);
        canvas.drawLine(350,400,350,550, drawPaint);
        canvas.drawLine(600,400,600,550, drawPaint);
        canvas.drawLine(850,400,850,550, drawPaint);

        // Row 3 of the pattern
        canvas.drawLine(150,600,300,600, drawPaint);
        canvas.drawLine(400,600,550,600, drawPaint);
        canvas.drawLine(650,600,800,600, drawPaint);

        canvas.drawLine(100,650,100,800, drawPaint);
        canvas.drawLine(350,650,350,800, drawPaint);
        canvas.drawLine(600,650,600,800, drawPaint);
        canvas.drawLine(850,650,850,800, drawPaint);

        // Row 4 of the pattern
        canvas.drawLine(150,850,300,850, drawPaint);
        canvas.drawLine(400,850,550,850, drawPaint);
        canvas.drawLine(650,850,800,850, drawPaint);
    }

    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
    }

    private void setupPaint() {
        drawPaint = new Paint();
        //drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}
