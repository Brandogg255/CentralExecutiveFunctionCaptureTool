package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class patternActivity extends AppCompatActivity {

    ImageButton imgButton1;
    ImageButton imgButton2;
    ImageButton imgButton3;
    ImageButton imgButton4;
    ImageButton imgButton5;
    ImageButton imgButton6;
    ImageButton imgButton7;
    ImageButton imgButton8;
    ImageButton imgButton9;
    ImageButton imgButton10;
    ImageButton imgButton11;
    ImageButton imgButton12;
    ImageButton imgButton13;
    ImageButton imgButton14;
    ImageButton imgButton15;
    ImageButton imgButton16;

    Button readyButton;

    View textViewReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern2);

        textViewReminder = (TextView)findViewById(R.id.textViewRemember);

        readyButton = (Button)findViewById(R.id.readyButton);

        //List each button in the pattern for class to access
        imgButton1 = (ImageButton)findViewById(R.id.imageButton1);
        imgButton2 = (ImageButton)findViewById(R.id.imageButton2);
        imgButton3 = (ImageButton)findViewById(R.id.imageButton3);
        imgButton4 = (ImageButton)findViewById(R.id.imageButton4);
        imgButton5 = (ImageButton)findViewById(R.id.imageButton5);
        imgButton6 = (ImageButton)findViewById(R.id.imageButton6);
        imgButton7 = (ImageButton)findViewById(R.id.imageButton7);
        imgButton8 = (ImageButton)findViewById(R.id.imageButton8);
        imgButton9 = (ImageButton)findViewById(R.id.imageButton9);
        imgButton10 = (ImageButton)findViewById(R.id.imageButton10);
        imgButton11 = (ImageButton)findViewById(R.id.imageButton11);
        imgButton12 = (ImageButton)findViewById(R.id.imageButton12);
        imgButton13 = (ImageButton)findViewById(R.id.imageButton13);
        imgButton14 = (ImageButton)findViewById(R.id.imageButton14);
        imgButton15 = (ImageButton)findViewById(R.id.imageButton15);
        imgButton16 = (ImageButton)findViewById(R.id.imageButton16);

        SamplePattern();
        //Set a listener for ready button to be pressed
        //Start Countdown
        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCountDown();
            }
        });

        // Reveal a blank pattern

        //Listerns for the buttons
        imgButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton1.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton2.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton3.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton4.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton5.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton6.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton7.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton8.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton9.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton10.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton11.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton12.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    imgButton13.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton14.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton15.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
        imgButton16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imgButton16.setImageResource(R.drawable.node_selected);
                return false;
            }
        });
    }

    private void startCountDown() {
        //Hide all views currently on page
        textViewReminder.setVisibility(View.GONE);
        
    }

    private void SamplePattern() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton1.setImageResource(R.drawable.node_selected);
                    }
                }, 1000);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton2.setImageResource(R.drawable.node_selected);
                    }
                }, 1500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton6.setImageResource(R.drawable.node_selected);
                    }
                }, 2000);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton10.setImageResource(R.drawable.node_selected);
                    }
                }, 2500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton11.setImageResource(R.drawable.node_selected);
                    }
                }, 3000);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton12.setImageResource(R.drawable.node_selected);
                    }
                }, 3500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgButton8.setImageResource(R.drawable.node_selected);
                    }
                }, 4000);
            }
        }, 500); //Millisecond 500 delay
    }
}