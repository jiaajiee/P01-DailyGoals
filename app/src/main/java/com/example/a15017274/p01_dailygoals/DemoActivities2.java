package com.example.a15017274.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DemoActivities2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_activities2);

        Button btnBack = (Button) findViewById(R.id.btnBack);

        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();

        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");

        // Get the TextView object
        TextView tv = (TextView) findViewById(R.id.textView8);
        // Display the name and age on the TextView
        tv.setText("Read up on materials before class:\n" + info[0] + "\nArrive on time so as not to miss important part of the lesson:\n" + info[1]
                    +"\nAttempt the problem myself:\n" + info[2] + "\nMy personal reflection today:\n" + info[3]);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }
}
