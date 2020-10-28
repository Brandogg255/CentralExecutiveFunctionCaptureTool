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
        /*canvas.drawLine(150,100,325,100, drawPaint);
        canvas.drawLine(420,100,582,100, drawPaint);
        canvas.drawLine(677,100,848,100, drawPaint);

        canvas.drawLine(100,150,100,300, drawPaint);
        canvas.drawLine(375,150,375,300, drawPaint);
        canvas.drawLine(632,150,632,300, drawPaint);
        canvas.drawLine(893,150,893,300, drawPaint);

        // Row 2 of the pattern
        canvas.drawLine(150,350,325,350, drawPaint);
        canvas.drawLine(420,350,582,350, drawPaint);
        canvas.drawLine(677,350,848,350, drawPaint);

        canvas.drawLine(100,400,100,550, drawPaint);
        canvas.drawLine(375,400,375,550, drawPaint);
        canvas.drawLine(632,400,632,550, drawPaint);
        canvas.drawLine(893,400,893,550, drawPaint);

        // Row 3 of the pattern
        canvas.drawLine(150,600,325,600, drawPaint);
        canvas.drawLine(420,600,582,600, drawPaint);
        canvas.drawLine(677,600,848,600, drawPaint);

        canvas.drawLine(100,650,100,800, drawPaint);
        canvas.drawLine(375,650,375,800, drawPaint);
        canvas.drawLine(632,650,632,800, drawPaint);
        canvas.drawLine(893,650,893,800, drawPaint);

        // Row 4 of the pattern
        canvas.drawLine(150,850,325,850, drawPaint);
        canvas.drawLine(420,850,582,850, drawPaint);
        canvas.drawLine(677,850,848,850, drawPaint);*/
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
