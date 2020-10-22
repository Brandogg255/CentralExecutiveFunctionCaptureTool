package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class information extends AppCompatActivity {
    private Button button;
    private String name;
    private String age;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        button = (Button) findViewById(R.id.buttonContinue);

        //Grab Information from detailActivity.java
        name = getIntent().getStringExtra("Name");
        age = getIntent().getStringExtra("Age");
        gender = getIntent().getStringExtra("Gender");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPattern();
            }
        });
    }

    public void openPattern() {
        Intent intent = new Intent(this, patternActivity.class);

        //Push data to patternActivity to be stored in a CSV File
        intent.putExtra("Name", name);
        intent.putExtra("Age", age);
        intent.putExtra("Gender", gender);

        startActivity(intent);
    }
}