package com.example.mobilemappingapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;

import android.content.Context;

import android.hardware.*;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;


public class Detection extends Activity implements SensorEventListener {


    private SensorManager sensorManager;

    private TextView count;

    boolean activityRunning;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        count = (TextView) findViewById(R.id.count);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);



    }



    @Override

    protected void onResume() {

        super.onResume();

        activityRunning = true;

        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (countSensor != null) {

            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);

        } else {

            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();

        }


    }


    @Override

    protected void onPause() {

        super.onPause();

        activityRunning = false;

        // if you unregister the last listener, the hardware will stop detecting step events

//        sensorManager.unregisterListener(this);

    }


    @Override

    public void onSensorChanged(SensorEvent event) {

        if (activityRunning) {

            count.setText(String.valueOf((int)event.values[0]));

        }


    }


    @Override

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
