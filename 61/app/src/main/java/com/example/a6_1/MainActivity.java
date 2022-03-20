package com.example.a6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock; 
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer1;
    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chronometer1 = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        dPicker = (DatePicker) findViewById(R.id.datePicker1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);


        chronometer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
                chronometer1.start();
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.setTextColor(Color.RED);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1+dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);

                return false;
            }

        });

    }

}