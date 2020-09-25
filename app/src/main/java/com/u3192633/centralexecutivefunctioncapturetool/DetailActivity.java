package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    private Button button;
    private EditText mEditPersonName;
    private EditText mEditAge;
    //Changing to drop down menu //private EditText mEditGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button = (Button) findViewById(R.id.detailContinue);
        mEditPersonName = (EditText) findViewById(R.id.editTextPersonName);
        mEditAge = (EditText) findViewById(R.id.editNumberAge);
        //mEditGender = (EditText) findViewById(R.id.editTextGender);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinformation();
            }
        });
    }
    public void openinformation() {
        Intent intent = new Intent(this, information.class);
        startActivity(intent);
    }
}
