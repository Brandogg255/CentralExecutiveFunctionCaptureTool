package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class resultsActivity extends AppCompatActivity {

    public String name;
    public String age;
    public String gender;
    public String[] pattern1;
    public String[] pattern2;
    public String[] pattern3;
    public String[] pattern4;
    public String[] pattern5;
    public double totalNodesCorrect;
    public int totalNodesIncorrect;
    public double totalNodes;
    public int correctPatterns;
    public int incorrectPatterns;
    public int testID;
    Date currentTime;

    TextView scoreText;
    TextView totalScoreText;
    TextView secondsText;
    TextView accuracyText;

    Button exportBtn;

    double accuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);

        //Gather and assign all information from the patterns to the declared variables
        testID = new Random().nextInt((100000 - 0) + 1) + 0;
        name = getIntent().getStringExtra("Name");
        age = getIntent().getStringExtra("Age");
        gender = getIntent().getStringExtra("Gender");
        currentTime = Calendar.getInstance().getTime();
        pattern1 = getIntent().getStringArrayExtra("Pattern 1");
        pattern2 = getIntent().getStringArrayExtra("Pattern 2");
        pattern3 = getIntent().getStringArrayExtra("Pattern 3");
        pattern4 = getIntent().getStringArrayExtra("Pattern 4");
        pattern5 = getIntent().getStringArrayExtra("Pattern 5");
        totalNodesCorrect = getIntent().getIntExtra("TotalCorrectButtons", 0);
        totalNodesIncorrect = getIntent().getIntExtra("TotalIncorrectButtons", 0);
        totalNodes = getIntent().getIntExtra("TotalButtons", 0);
        correctPatterns = getIntent().getIntExtra("Correct Patterns", 0);
        incorrectPatterns = getIntent().getIntExtra("Incorrect Patterns", 0);

        //
        scoreText = (TextView)findViewById(R.id.textView18);
        totalScoreText = (TextView)findViewById(R.id.textView19);
        secondsText = (TextView)findViewById(R.id.secondsResults);
        accuracyText = (TextView)findViewById(R.id.accuracyResults);
        exportBtn = (Button)findViewById(R.id.exportBtn);

        Log.d("Time", "Pattern 1: Time 1" + pattern1[0]);

        accuracy = (totalNodesCorrect/totalNodes)*100;
        accuracy = Math.round(accuracy);
        accuracyText.setText(accuracy + "% accuracy");

        int totalNodesCorrectInt = (int) totalNodesCorrect;
        scoreText.setText(Integer.toString(totalNodesCorrectInt));
        int totalNodesInt = (int) totalNodes;
        totalScoreText.setText("out of " + Integer.toString(totalNodesInt));

        exportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "Data.csv";
                String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + fileName;
                File f = new File(filePath);
                CSVWriter writer;
                //File exist
                try {
                    if(f.exists() && !f.isDirectory()){
                        writer = new CSVWriter(new FileWriter(filePath, true));
                    } else {
                        writer = new CSVWriter(new FileWriter(filePath));
                    }
                    String[] data = getDataStringArray();

                    writer.writeNext(data);
                    writer.writeNext(pattern1);
                    writer.writeNext(pattern2);
                    writer.writeNext(pattern3);
                    writer.writeNext(pattern4);
                    writer.writeNext(pattern5);

                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public String[] getDataStringArray() {
        String[] data = {Integer.toString(testID), name, age, gender, String.valueOf(currentTime),
                String.valueOf(totalNodes), String.valueOf(totalNodesIncorrect),
                String.valueOf(totalNodesCorrect), String.valueOf(correctPatterns),
                String.valueOf(incorrectPatterns)};
        return data;
    }
}