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
import java.sql.Array;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class patternActivity extends AppCompatActivity {

    //Declare variables to gather information from the information.java activity
    private String name;
    private String age;
    private String gender;

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
    String [] correctButtonEntries = new String[17];
    //Need to update amount of items in string
    String [] csvOutput = new String[23];
    int buttonCounter;
    File fileNameButton;
    int difficulty;

    File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    File fileNameResults;

    int buttonsCorrect;
    int buttonsIncorrect;
    int totalButtonsCorrect;
    int totalButtonsIncorrect;

    int correctPatterns;
    int incorrectPatterns;
    int totalButtons;

    String [] buttonTimes = new String[16];

    String [] pattern1 = new String[20];
    String [] pattern2 = new String[20];
    String [] pattern3 = new String[20];
    String [] pattern4 = new String[20];
    String [] pattern5 = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern2);

        //Declare the value for pattern count to zero at the start of the class creation
        correctPatterns = 0;
        incorrectPatterns = 0;

        //Pull information from information class
        name = getIntent().getStringExtra("Name");
        age = getIntent().getStringExtra("Age");
        gender = getIntent().getStringExtra("Gender");

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
                buttonsCorrect = 0;
                buttonsIncorrect = 0;
                Log.d("contents", buttonEntries.toString());
                Log.d("correct", correctButtonEntries.toString());

                //Changing to buttonEntries causes crashing... Need to investigate
                int arrayLength = correctButtonEntries.length;
                totalButtons = arrayLength + totalButtons;
                for (int x = 0; x < arrayLength; x++) {
                    if (buttonEntries[x] == null) {
                        buttonEntries[x] = "";
                    }
                    if (buttonEntries[x].equals(correctButtonEntries[x])) {
                        Log.d("Message", "Correct Button " + x);
                        buttonsCorrect++;
                        totalButtonsCorrect++;
                    } else {
                        Log.d("Message", "Incorrect Button " + x);
                        buttonsIncorrect++;
                        totalButtonsIncorrect++;
                    }
                    Log.d("Z", Integer.toString(z));
                    if (z == 0) {
                        pattern1[x] = buttonTimes[x];
                        pattern1[arrayLength + 1] = Integer.toString(difficulty);
                        Log.d("Information1", pattern1[x] + " : " + pattern1[arrayLength + 1]);
                    } else if (z == 1) {
                        pattern2[x] = buttonTimes[x];
                        pattern2[arrayLength + 1] = Integer.toString(difficulty);
                        Log.d("Information2", pattern2[x] + " : " + pattern2[arrayLength + 1]);
                    } else if (z == 2) {
                        pattern3[x] = buttonTimes[x];
                        pattern3[arrayLength + 1] = Integer.toString(difficulty);
                        Log.d("Information3", pattern3[x] + " : " + pattern3[arrayLength + 1]);
                    } else if (z == 3) {
                        pattern4[x] = buttonTimes[x];
                        pattern4[arrayLength + 1] = Integer.toString(difficulty);
                        Log.d("Information4", pattern4[x] + " : " + pattern4[arrayLength + 1]);
                    } else if (z == 4) {
                        pattern5[x] = buttonTimes[x];
                        pattern5[arrayLength + 1] = Integer.toString(difficulty);
                        Log.d("Information5", pattern5[x] + " : " + pattern5[arrayLength + 1]);
                    }
                }

                if (buttonsIncorrect == 0) {
                    correctPatterns++;
                } else {
                    incorrectPatterns++;
                }
                Log.d("Results", "Correct Buttons " + buttonsCorrect + ", Buttons Incorrect " + buttonsIncorrect);
                if (z++ < 4) {
                    showPattern();
                    SamplePattern();
                    /*new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startCountDown();
                                }
                            }, delayVar);
                        }
                    }, 750);*/
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


        //Listens for the buttons
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton1.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 1 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton1";
                buttonCounter++;
            }
        });
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton2.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 2 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton2";
                buttonCounter++;
            }
        });
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton3.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 3 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton3";
                buttonCounter++;
            }
        });
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton4.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 4 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton4";
                buttonCounter++;
            }
        });
        imgButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton5.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 5 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton5";
                buttonCounter++;
            }
        });
        imgButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton6.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 6 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton6";
                buttonCounter++;
            }
        });
        imgButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton7.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 7 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton7";
                buttonCounter++;
            }
        });
        imgButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton8.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 8 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton8";
                buttonCounter++;
            }
        });
        imgButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton9.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 9 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton9";
                buttonCounter++;
            }
        });
        imgButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton10.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 10 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton10";
                buttonCounter++;
            }
        });
        imgButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton11.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 11 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton11";
                buttonCounter++;
            }
        });
        imgButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton12.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 12 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton12";
                buttonCounter++;
            }
        });
        imgButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton13.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 13 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton13";
                buttonCounter++;
            }
        });
        imgButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton14.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 14 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton14";
                buttonCounter++;
            }
        });
        imgButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton15.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 15 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton15";
                buttonCounter++;
            }
        });
        imgButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgButton16.setImageResource(R.drawable.node_selected);
                Log.d("Time", "Button 16 Time value in seconds "+ seconds + ":" + mCount);
                buttonTimes[buttonCounter] = (seconds + "." + mCount);
                buttonEntries[buttonCounter] = "imgButton16";
                buttonCounter++;
            }
        });
    }

    private void openResults() {
        Intent intent = new Intent(this, resultsActivity.class);

        totalButtons = totalButtonsCorrect + totalButtonsIncorrect;
        //Parse Information to Results Page
        intent.putExtra("Name", name);
        intent.putExtra("Age", age);
        intent.putExtra("Gender", gender);
        intent.putExtra("Pattern 1", pattern1);
        intent.putExtra("Pattern 2", pattern2);
        intent.putExtra("Pattern 3", pattern3);
        intent.putExtra("Pattern 4", pattern4);
        intent.putExtra("Pattern 5", pattern5);
        intent.putExtra("TotalCorrectButtons", totalButtonsCorrect);
        intent.putExtra("TotalIncorrectButtons", totalButtonsIncorrect);
        intent.putExtra("TotalButtons", totalButtons);
        intent.putExtra("Correct Patterns", correctPatterns);
        intent.putExtra("Incorrect Patterns", incorrectPatterns);

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
        continueButton.setVisibility(View.GONE);
        buttonTimes = new String[16];
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
        final int min = 1;
        final int max = 10;
        int random = new Random().nextInt((max - min) + 1) + min;
        Log.d("Number", Integer.toString(random));
        switch (random) {
            //Difficulty 1 Pattern 1
            case 1:
                correctButtonEntries = new String[2];
                continueButton.setVisibility(View.GONE);
                difficulty = 1;
                delayVar = 3500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton11";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton15";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 1500);
                    }
                }, 1500);
                break;
            case 2:
                correctButtonEntries = new String[2];
                continueButton.setVisibility(View.GONE);
                difficulty = 1;
                delayVar = 3500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton10";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton9";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 1500);
                    }
                }, 1500);
                break;
            //Difficulty 2 Pattern 1
            case 3:
                correctButtonEntries = new String[4];
                continueButton.setVisibility(View.GONE);
                difficulty = 2;
                delayVar = 4500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton2.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton2";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton6";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton10";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton9";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 2500);
                    }
                }, 1500);
                break;
            case 4:
                correctButtonEntries = new String[4];
                continueButton.setVisibility(View.GONE);
                difficulty = 2;
                delayVar = 4500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton8";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton7";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton6";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton2.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton2";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 2500);
                    }
                }, 1500);
                break;
            //Difficulty 3 Pattern 1
            case 5:
                correctButtonEntries = new String[6];
                continueButton.setVisibility(View.GONE);
                difficulty = 3;
                delayVar = 5500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton16";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton12.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton12";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton11";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton7";
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton3.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[4] = "imgButton3";
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[5] = "imgButton4";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 3500);
                    }
                }, 1500);
                break;
            case 6:
                correctButtonEntries = new String[6];
                continueButton.setVisibility(View.GONE);
                difficulty = 3;
                delayVar = 5500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton13.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton13";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton14";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton10";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton11";
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton12.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[4] = "imgButton12";
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[5] = "imgButton16";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 3500);
                    }
                }, 1500);
                break;
            //Difficulty 4 Pattern 1
            case 7:
                correctButtonEntries = new String[9];
                continueButton.setVisibility(View.GONE);
                difficulty = 4;
                delayVar = 6500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton13.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton13";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton14";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton10";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton6";
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[4] = "imgButton7";
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[5] = "imgButton11";
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton12.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[6] = "imgButton12";
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[7] = "imgButton8";
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[8] = "imgButton4";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 5000);
                    }
                }, 1500);
                break;
            case 8:
                correctButtonEntries = new String[9];
                continueButton.setVisibility(View.GONE);
                difficulty = 4;
                delayVar = 6500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton1.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton1";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton5.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton5";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton6";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton7";
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[4] = "imgButton11";
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[5] = "imgButton10";
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[6] = "imgButton14";
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[7] = "imgButton15";
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[8] = "imgButton16";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 5000);
                    }
                }, 1500);
                break;
            //Difficulty 5 Pattern 1
            case 9:
                correctButtonEntries = new String[13];
                continueButton.setVisibility(View.GONE);
                difficulty = 5;
                delayVar = 8500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton16";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton15";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton14.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton14";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton10";
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[4] = "imgButton11";
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[5] = "imgButton7";
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[6] = "imgButton8";
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[7] = "imgButton4";
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton3.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[8] = "imgButton3";
                            }
                        }, 5000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton2.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[9] = "imgButton2";
                            }
                        }, 5500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[10] = "imgButton6";
                            }
                        }, 6000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton5.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[11] = "imgButton5";
                            }
                        }, 6500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[12] = "imgButton9";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 7000);
                    }
                }, 1500);
                break;
            case 10:
                correctButtonEntries = new String[13];
                continueButton.setVisibility(View.GONE);
                difficulty = 5;
                delayVar = 8500;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton13.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[0] = "imgButton13";
                            }
                        }, 1000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[1] = "imgButton9";
                            }
                        }, 1500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton5.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[2] = "imgButton5";
                            }
                        }, 2000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton6.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[3] = "imgButton6";
                            }
                        }, 2500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton10.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[4] = "imgButton10";
                            }
                        }, 3000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton11.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[5] = "imgButton11";
                            }
                        }, 3500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton15.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[6] = "imgButton15";
                            }
                        }, 4000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton16.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[7] = "imgButton16";
                            }
                        }, 4500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton8.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[8] = "imgButton12";
                            }
                        }, 5000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton7.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[9] = "imgButton8";
                            }
                        }, 5500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton3.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[10] = "imgButton7";
                            }
                        }, 6000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton4.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[11] = "imgButton3";
                            }
                        }, 6500);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[12] = "imgButton4";
                            }
                        }, 7000);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgButton9.setImageResource(R.drawable.node_selected);
                                correctButtonEntries[12] = "imgButton9";
                                if (z > 0) {
                                    readyButton.setVisibility(View.VISIBLE);
                                }
                            }
                        }, 7500);
                    }
                }, 1500);
                break;
        }
    }
}