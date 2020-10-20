package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
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

    //Timer Variables
    long seconds = 0;
    long millis = 0;
    int mCount = 0;
    Timer timer;
    int delayVar;

    //Counter for random patterns
    int z = 0;

    //Database Storage for Button comparison
    String [] buttonEntries = new String[17];
    //Need to update amount of items in string
    String [] csvOutput = new String[23];
    int buttonCounter;
    File fileNameButton;
    int difficulty;
    //String fileNameButton = "button.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern2);

        File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        fileNameButton = new File(directory, "button.csv");

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

        //Code for continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {

                        FileOutputStream fosb = new FileOutputStream(fileNameButton);
                        OutputStreamWriter oswb = new OutputStreamWriter(fosb, StandardCharsets.UTF_8);
                        CSVWriter writer = new CSVWriter(oswb);
                        Log.d("path", fileNameButton.toString());
                        Log.d("contents", buttonEntries.toString());

                        writer.writeNext(buttonEntries);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (z++ < 4) {
                    showPattern();
                    SamplePattern();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startCountDown();
                                }
                            }, delayVar);

                        }
                    }, 500);
                    //startCountDown();
                    Log.d("Count", Integer.toString(z));
                } else {
                    openResults();
                }
            }
        });

        //Timer code
        timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    timerMethod();
                }
            }, 1,100);


        //Listerns for the buttons
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton1.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 1 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton1";
                buttonCounter++;
            }
        });
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton2.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 2 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton2";
                buttonCounter++;
            }
        });
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton3.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 3 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton3";
                buttonCounter++;
            }
        });
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton4.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 4 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton4";
                buttonCounter++;
            }
        });
        imgButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton5.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 5 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton5";
                buttonCounter++;
            }
        });
        imgButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton6.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 6 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton6";
                buttonCounter++;
            }
        });
        imgButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton7.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 7 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton7";
                buttonCounter++;
            }
        });
        imgButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton8.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 8 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton8";
                buttonCounter++;
            }
        });
        imgButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton9.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 9 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton9";
                buttonCounter++;
            }
        });
        imgButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton10.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 10 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton10";
                buttonCounter++;
            }
        });
        imgButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton11.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 11 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton11";
                buttonCounter++;
            }
        });
        imgButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton12.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 12 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton12";
                buttonCounter++;
            }
        });
        imgButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton13.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 13 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton13";
                buttonCounter++;
            }
        });
        imgButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton14.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 14 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton14";
                buttonCounter++;
            }
        });
        imgButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton15.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 15 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton15";
                buttonCounter++;
            }
        });
        imgButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton16.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 16 Time value in seconds "+ seconds + ":" + mCount);
                buttonEntries[buttonCounter] = "imgButton16";
                buttonCounter++;
            }
        });
    }

    private void openResults() {
        Intent intent = new Intent(this, resultsActivity.class);
        startActivity(intent);
    }

    private void timerMethod(){
        this.runOnUiThread(generate);
    }
    private Runnable generate = new Runnable() {
        @Override
        public void run() {
            mCount++;
            if (mCount == 10) {
                mCount = 0;
                seconds++;
            }
        }
    };

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
        //Reset variables to 0
        buttonCounter = 0;

        //Hide all views currently on page
        textViewCountdown.setText("5");
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
                }, 100);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("4");
                    }
                }, 1100);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("3");
                    }
                }, 2100);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("2");
                    }
                }, 3100);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setText("1");
                    }
                }, 4100);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewCountdown.setVisibility(View.INVISIBLE);
                        showPattern();
                        seconds = 0;
                        mCount = 0;
                    }
                }, 5100);
            }
        }, 100);
    }

    private void SamplePattern() {
        final int min = 0;
        final int max = 10;
        final int random = new Random().nextInt((max - min) + 1) + min;
        Log.d("Number", Integer.toString(random));
        switch (random) {
            //Difficulty 1 Pattern 1
            case 1:
                difficulty = 1;
                delayVar = 3500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                    }
                }, 500);
                break;
            case 2:
                difficulty = 1;
                delayVar = 3500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                    }
                }, 500);
                break;
            //Difficulty 2 Pattern 1
            case 3:
                difficulty = 2;
                delayVar = 4500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton2.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                            }
                        }, 2500);
                    }
                }, 500);
                break;
            case 4:
                difficulty = 2;
                delayVar = 4500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
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
                                imgButton2.setImageResource(R.drawable.node_selected);
                            }
                        }, 2500);
                    }
                }, 500);
                break;
            //Difficulty 3 Pattern 1
            case 5:
                difficulty = 3;
                delayVar = 5500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton12.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton3.setImageResource(R.drawable.node_selected);
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                            }
                        }, 3500);
                    }
                }, 500);
                break;
            case 6:
                difficulty = 3;
                delayVar = 5500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton13.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton12.setImageResource(R.drawable.node_selected);
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                            }
                        }, 3500);
                    }
                }, 500);
                break;
            //Difficulty 4 Pattern 1
            case 7:
                difficulty = 4;
                delayVar = 6500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton13.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton12.setImageResource(R.drawable.node_selected);
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                            }
                        }, 5000);
                    }
                }, 500);
                break;
            case 8:
                difficulty = 4;
                delayVar = 6500;
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
                                imgButton5.setImageResource(R.drawable.node_selected);
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
                                imgButton7.setImageResource(R.drawable.node_selected);
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
                                imgButton10.setImageResource(R.drawable.node_selected);
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                            }
                        }, 5000);
                    }
                }, 500);
                break;
            //Difficulty 5 Pattern 1
            case 9:
                difficulty = 5;
                delayVar = 8500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
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
                                imgButton7.setImageResource(R.drawable.node_selected);
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton3.setImageResource(R.drawable.node_selected);
                            }
                        }, 5000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton2.setImageResource(R.drawable.node_selected);
                            }
                        }, 5500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                            }
                        }, 6000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton5.setImageResource(R.drawable.node_selected);
                            }
                        }, 6500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                            }
                        }, 7000);
                    }
                }, 500);
                break;
            case 10:
                difficulty = 5;
                delayVar = 8500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton13.setImageResource(R.drawable.node_selected);
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton5.setImageResource(R.drawable.node_selected);
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                            }
                        }, 5000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                            }
                        }, 5500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton3.setImageResource(R.drawable.node_selected);
                            }
                        }, 6000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                            }
                        }, 6500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                            }
                        }, 7000);
                    }
                }, 500);
                break;
        }
    }
}