package com.example.mobilemappingapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Arsalan Babar Test CHECKKKKK
//OB
//Renz
public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showGreetings(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Open Step Detector")) {
            Intent intent = new Intent(this, Detection.class);
            startActivity(intent);
        } else if (button_text.equals("Open Accelerometer Data")) {
            Intent intent = new Intent(this, Accelerometer.class);
            startActivity(intent);
        } else if (button_text.equals("Open Gyroscope Data")) {
            Intent intent = new Intent(this, Gyroscope.class);
            startActivity(intent);
        }
    }
}

