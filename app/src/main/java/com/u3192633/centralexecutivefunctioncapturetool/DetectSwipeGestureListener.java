package com.u3192633.centralexecutivefunctioncapturetool;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.content.Intent;

// Swiping Gesture Function
import androidx.constraintlayout.widget.ConstraintSet;

public class DetectSwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

    // Declaring the Y axis swipe Gesture
    private static int MIN_SWIPE_DISTANCE_Y = 50;


    private static int MAX_SWIPE_DISTANCE_Y = 1000;


    // Main Activity
    private MainActivity activity = null;


    public MainActivity gestureActivity() {
        return activity;

    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    // Swiping function, that triggers button activity once swipe is made
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        //detect up down swipes
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if(deltaY > 0) {
                this.activity.openPopActivity();
            }
        }

        return true;

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.activity.openDetailActivity();
        return true;
    }
}
