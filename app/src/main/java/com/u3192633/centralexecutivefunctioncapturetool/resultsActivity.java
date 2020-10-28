package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

    TextView scoreText;
    TextView totalScoreText;
    TextView secondsText;
    TextView accuracyText;

    double accuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);

        //Gather and assign all information from the patterns to the declared variables
        name = getIntent().getStringExtra("Name");
        age = getIntent().getStringExtra("Age");
        gender = getIntent().getStringExtra("Gender");
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

        Log.d("Time", "Pattern 1: Time 1" + pattern1[0]);

        accuracy = (totalNodesCorrect/totalNodes)*100;
        accuracy = Math.round(accuracy);
        accuracyText.setText(accuracy + "% accuracy");

        int totalNodesCorrectInt = (int) totalNodesCorrect;
        scoreText.setText(Integer.toString(totalNodesCorrectInt));
        int totalNodesInt = (int) totalNodes;
        totalScoreText.setText("out of " + Integer.toString(totalNodesInt));
    }
}