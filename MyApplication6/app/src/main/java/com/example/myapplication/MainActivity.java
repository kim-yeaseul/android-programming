package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calview;
    TimePicker tPicker;
    TextView tvYear,tvMonth,tvDay,tvHour,tvMiunute;
    int selectYear, selectMonth, selectDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
            }
        });

    }
}