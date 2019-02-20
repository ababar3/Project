package com.example.mobilemappingapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager SM;
    private TextView count;
    boolean activityRunning;


    TextView textX, textY, textZ;

    SensorManager sensorManager;
    boolean running = false;
    Sensor sensor;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdlayout);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);





        //Create Our Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        //ACCELEROMETER
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register Sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign TextView
        xText = (TextView) findViewById(R.id.textX);
        yText = (TextView) findViewById(R.id.textY);
        zText = (TextView) findViewById(R.id.zText);

    }


    @Override
    public void onResume () {

        super.onResume();

        sensorManager.registerListener(gyroListener, sensor,

                SensorManager.SENSOR_DELAY_NORMAL);


    }


    public void onStop () {

        super.onStop();

        sensorManager.unregisterListener(gyroListener);

    }
    @Override

    protected void onPause() {

        super.onPause();

        activityRunning = false;

        // if you unregister the last listener, the hardware will stop detecting step events

//        sensorManager.unregisterListener(this);

    }

    public SensorEventListener gyroListener = new SensorEventListener() {

        public void onAccuracyChanged(Sensor sensor, int acc) {
        }


        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];

            float y = event.values[1];

            float z = event.values[2];


            if (activityRunning) {

                count.setText(String.valueOf(event.values[0]));

            }

        }

    };


    @Override
    public void onSensorChanged (SensorEvent event){
        xText.setText("X:" + String.format("%.2f", event.values[0]));
        yText.setText("Y:" + String.format("%.2f", event.values[1]));
        zText.setText("Z:" + String.format("%.2f", event.values[2]));
    }

    @Override
    public void onAccuracyChanged (Sensor sensor,int accuracy){
        //Not in use
    }

}