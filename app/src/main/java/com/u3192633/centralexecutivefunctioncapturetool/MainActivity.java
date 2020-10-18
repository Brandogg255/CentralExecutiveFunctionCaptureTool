package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


// Main Activity function on Landing page
public class MainActivity extends AppCompatActivity {
    private Button button;
    Button btn_sub;
    TextView textView;
    private GestureDetectorCompat gestureDetectorCompat = null;
    private Button exitBtn;

    // Button Activities such as clicking to next page and swiping up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {

                      openPopActivity();
            }
        });

        button = (Button) findViewById(R.id.mainContinue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });



        textView = findViewById(R.id.textView);


        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


    }



    // All open function buttons for swipe and tap buttons

    public void openPopActivity(){
        Intent intent = new Intent(this, PopActivity.class);
        startActivity(intent);
    }

    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }


    public void openDetailActivity() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }



}
