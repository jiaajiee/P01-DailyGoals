package com.example.a15017274.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnok = (Button) findViewById(R.id.buttonOk);
        btnok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Get the EditText that user keys in name
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                EditText etReflec = (EditText) findViewById(R.id.editText2);

                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);


                String[] info = {rb.getText().toString(),
                        rb2.getText().toString(),
                        rb3.getText().toString(),
                        etReflec.getText().toString()};

                // Create an intent to start another activity called
                //  DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this,
                        DemoActivities2.class);
                // Pass the radio button & edit text to new activity
                i.putExtra("info", info);
                // Start the new activity
                startActivity(i);


                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("rg", selectedButtonId);
                prefEdit.putInt("rg2", selectedButtonId2);
                prefEdit.putInt("rg3", selectedButtonId3);
                prefEdit.putString("et", etReflec.getText().toString());
                prefEdit.commit();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        EditText etReflec = (EditText) findViewById(R.id.editText2);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int rb = prefs.getInt("rg", 0);
        int rb2 = prefs.getInt("rg2", 0);
        int rb3 = prefs.getInt("rg3", 0);
        String et = prefs.getString("et", "");

        etReflec.setText(et);
        rg.check(rb);
        rg2.check(rb2);
        rg3.check(rb3);
    }
}

