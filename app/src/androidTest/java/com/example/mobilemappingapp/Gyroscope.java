package com.example.mobilemappingapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class Gyroscope extends AppCompatActivity implements SensorEventListener {
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
        setContentView(R.layout.gyrolayout);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        //Gyro Code

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);


        textX = (TextView) findViewById(R.id.textX);

        textY = (TextView) findViewById(R.id.textY);

        textZ = (TextView) findViewById(R.id.textZ);


        //Create Our Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Register Sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);



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


            textX.setText("X : " + (int) x + " rad/s");

            textY.setText("Y : " + (int) y + " rad/s");

            textZ.setText("Z : " + (int) z + " rad/s");

            if (activityRunning) {

                count.setText(String.valueOf(event.values[0]));

            }

        }

    };


    @Override
    public void onSensorChanged (SensorEvent event){

    }

    @Override
    public void onAccuracyChanged (Sensor sensor,int accuracy){
        //Not in use
    }

}
