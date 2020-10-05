package com.u3192633.centralexecutivefunctioncapturetool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SimpleDrawingView extends View {

    // setup initial color
    private final int paintColor = Color.BLACK;
    // defines paint and canvas
    private Paint drawPaint;

    public int circle11 = Color.BLACK;
    public int circle12 = Color.BLACK;
    public int circle13 = Color.BLACK;
    public int circle14 = Color.BLACK;

    public int circle21 = Color.BLACK;
    public int circle22 = Color.BLACK;
    public int circle23 = Color.BLACK;
    public int circle24 = Color.BLACK;

    public int circle31 = Color.BLACK;
    public int circle32 = Color.BLACK;
    public int circle33 = Color.BLACK;
    public int circle34 = Color.BLACK;

    public int circle41 = Color.BLACK;
    public int circle42 = Color.BLACK;
    public int circle43 = Color.BLACK;
    public int circle44 = Color.BLACK;

    // Lets draw the pattern
    @Override
    protected void onDraw(Canvas canvas) {
        // Row 1 of the pattern
        canvas.drawColor(circle11);
        canvas.drawCircle(100, 100, 50, drawPaint);
        canvas.drawLine(150,100,300,100, drawPaint);
        canvas.drawColor(circle12);
        canvas.drawCircle(350, 100, 50, drawPaint);
        canvas.drawLine(400,100,550,100, drawPaint);
        canvas.drawColor(circle13);
        canvas.drawCircle(600, 100, 50, drawPaint);
        canvas.drawLine(650,100,800,100, drawPaint);
        canvas.drawColor(circle14);
        canvas.drawCircle(850, 100, 50, drawPaint);

        canvas.drawLine(100,150,100,300, drawPaint);
        canvas.drawLine(350,150,350,300, drawPaint);
        canvas.drawLine(600,150,600,300, drawPaint);
        canvas.drawLine(850,150,850,300, drawPaint);

        // Row 2 of the pattern
        canvas.drawColor(circle21);
        canvas.drawCircle(100, 350, 50, drawPaint);
        canvas.drawLine(150,350,300,350, drawPaint);
        canvas.drawColor(circle22);
        canvas.drawCircle(350, 350, 50, drawPaint);
        canvas.drawLine(400,350,550,350, drawPaint);
        canvas.drawColor(circle23);
        canvas.drawCircle(600, 350, 50, drawPaint);
        canvas.drawLine(650,350,800,350, drawPaint);
        canvas.drawColor(circle24);
        canvas.drawCircle(850, 350, 50, drawPaint);

        canvas.drawLine(100,400,100,550, drawPaint);
        canvas.drawLine(350,400,350,550, drawPaint);
        canvas.drawLine(600,400,600,550, drawPaint);
        canvas.drawLine(850,400,850,550, drawPaint);

        // Row 3 of the pattern
        canvas.drawColor(circle31);
        canvas.drawCircle(100, 600, 50, drawPaint);
        canvas.drawLine(150,600,300,600, drawPaint);
        canvas.drawColor(circle32);
        canvas.drawCircle(350, 600, 50, drawPaint);
        canvas.drawLine(400,600,550,600, drawPaint);
        canvas.drawColor(circle33);
        canvas.drawCircle(600, 600, 50, drawPaint);
        canvas.drawLine(650,600,800,600, drawPaint);
        canvas.drawColor(circle34);
        canvas.drawCircle(850, 600, 50, drawPaint);

        canvas.drawLine(100,650,100,800, drawPaint);
        canvas.drawLine(350,650,350,800, drawPaint);
        canvas.drawLine(600,650,600,800, drawPaint);
        canvas.drawLine(850,650,850,800, drawPaint);

        // Row 4 of the pattern
        canvas.drawColor(circle41);
        canvas.drawCircle(100, 850, 50, drawPaint);
        canvas.drawLine(150,850,300,850, drawPaint);
        canvas.drawColor(circle42);
        canvas.drawCircle(350, 850, 50, drawPaint);
        canvas.drawLine(400,850,550,850, drawPaint);
        canvas.drawColor(circle43);
        canvas.drawCircle(600, 850, 50, drawPaint);
        canvas.drawLine(650,850,800,850, drawPaint);
        canvas.drawColor(circle44);
        canvas.drawCircle(850, 850, 50, drawPaint);
    }

    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}
