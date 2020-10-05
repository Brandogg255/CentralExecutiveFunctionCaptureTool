package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class information extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        button = (Button) findViewById(R.id.buttonContinue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPattern();
            }
        });
    }

    public void openPattern() {
        Intent intent = new Intent(this, patternActivity.class);
        startActivity(intent);
    }
}