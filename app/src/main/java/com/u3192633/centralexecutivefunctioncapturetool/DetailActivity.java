package com.u3192633.centralexecutivefunctioncapturetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailActivity extends AppCompatActivity {
    private Button button;
    private EditText mEditPersonName;
    private EditText mEditAge;
    private Spinner mSpinnerGender;
    //Changing to drop down menu //private EditText mEditGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button = (Button) findViewById(R.id.detailContinue);
        mEditPersonName = (EditText) findViewById(R.id.editTextPersonName);
        mEditAge = (EditText) findViewById(R.id.editNumberAge);
        mSpinnerGender = findViewById(R.id.spinnerGender);

        String[] items = new String[]{"Male", "Female", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mSpinnerGender.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInformation();
            }
        });
    }
    public void openInformation() {
        Intent intent = new Intent(this, information.class);

        //Parse information from this screen forward to get to CSV file for data output
        intent.putExtra("Name", mEditPersonName.toString());
        intent.putExtra("Age", mEditAge.toString());
        intent.putExtra("Gender", mSpinnerGender.getSelectedItem().toString());

        startActivity(intent);
    }
}
