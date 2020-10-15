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

    boolean isPaused = true;

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
    Button continueButton;

    View textViewReminder;
    TextView textViewCountdown;

    View simpleDrawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern2);

        textViewReminder = (TextView)findViewById(R.id.textViewRemember);
        textViewCountdown = (TextView)findViewById(R.id.textViewCountdown);

        readyButton = (Button)findViewById(R.id.readyButton);
        continueButton = (Button)findViewById(R.id.continueButton);

        simpleDrawingView = (View)findViewById(R.id.simpleDrawingView);

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
        //Code is in countdown

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

    private void showPattern() {
        imgButton1.setVisibility(View.VISIBLE);
        imgButton2.setVisibility(View.VISIBLE);
        imgButton3.setVisibility(View.VISIBLE);
        imgButton4.setVisibility(View.VISIBLE);
        imgButton5.setVisibility(View.VISIBLE);
        imgButton6.setVisibility(View.VISIBLE);
        imgButton7.setVisibility(View.VISIBLE);
        imgButton8.setVisibility(View.VISIBLE);
        imgButton9.setVisibility(View.VISIBLE);
        imgButton10.setVisibility(View.VISIBLE);
        imgButton11.setVisibility(View.VISIBLE);
        imgButton12.setVisibility(View.VISIBLE);
        imgButton13.setVisibility(View.VISIBLE);
        imgButton14.setVisibility(View.VISIBLE);
        imgButton15.setVisibility(View.VISIBLE);
        imgButton16.setVisibility(View.VISIBLE);
        simpleDrawingView.setVisibility(View.VISIBLE);
        textViewReminder.setVisibility(View.INVISIBLE);
        continueButton.setVisibility(View.VISIBLE);
        //Set all Img Buttons to Unselected ready for the user to select the pattern
        imgButton1.setImageResource(R.drawable.node_unselected);
        imgButton2.setImageResource(R.drawable.node_unselected);
        imgButton3.setImageResource(R.drawable.node_unselected);
        imgButton4.setImageResource(R.drawable.node_unselected);
        imgButton5.setImageResource(R.drawable.node_unselected);
        imgButton6.setImageResource(R.drawable.node_unselected);
        imgButton7.setImageResource(R.drawable.node_unselected);
        imgButton8.setImageResource(R.drawable.node_unselected);
        imgButton9.setImageResource(R.drawable.node_unselected);
        imgButton10.setImageResource(R.drawable.node_unselected);
        imgButton11.setImageResource(R.drawable.node_unselected);
        imgButton12.setImageResource(R.drawable.node_unselected);
        imgButton13.setImageResource(R.drawable.node_unselected);
        imgButton14.setImageResource(R.drawable.node_unselected);
        imgButton15.setImageResource(R.drawable.node_unselected);
        imgButton16.setImageResource(R.drawable.node_unselected);
    }

    private void startCountDown() {
        //Hide all views currently on page
        textViewReminder.setVisibility(View.GONE);
        imgButton1.setVisibility(View.GONE);
        imgButton2.setVisibility(View.GONE);
        imgButton3.setVisibility(View.GONE);
        imgButton4.setVisibility(View.GONE);
        imgButton5.setVisibility(View.GONE);
        imgButton6.setVisibility(View.GONE);
        imgButton7.setVisibility(View.GONE);
        imgButton8.setVisibility(View.GONE);
        imgButton9.setVisibility(View.GONE);
        imgButton10.setVisibility(View.GONE);
        imgButton11.setVisibility(View.GONE);
        imgButton12.setVisibility(View.GONE);
        imgButton13.setVisibility(View.GONE);
        imgButton14.setVisibility(View.GONE);
        imgButton15.setVisibility(View.GONE);
        imgButton16.setVisibility(View.GONE);
        simpleDrawingView.setVisibility(View.GONE);
        readyButton.setVisibility(View.GONE);

        //Start the countdown
        textViewCountdown.setVisibility(View.VISIBLE);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("5");
                    }
                }, 500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("4");
                    }
                }, 1500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("3");
                    }
                }, 2500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("2");
                    }
                }, 3500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("1");
                    }
                }, 4500);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setVisibility(View.INVISIBLE);
                        showPattern();
                    }
                }, 5500);
            }
        }, 500);
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