package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Edit1, Edit2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv, BtnRm ;
    TextView TextResult;
    String num1, num2 ;
    Float result ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기 (수정)");

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);

        BtnAdd = (Button) findViewById(R.id.BtnAdd);
        BtnSub = (Button) findViewById(R.id.BtnSub);
        BtnMul = (Button) findViewById(R.id.BtnMul);
        BtnDiv = (Button) findViewById(R.id.BtnDiv);
        BtnRm = (Button) findViewById(R.id.BtnRM);

        TextResult = (TextView) findViewById(R.id.TextResult);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.trim().equals("")|| num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력 값이 비었습니다",Toast.LENGTH_SHORT)
                            .show();
                }else {
                    result= Float.parseFloat(num1) + Float.parseFloat(num2);
                    TextResult.setText("계산 결과 :" + result.toString());

                }}


        });
        BtnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    result= Float.parseFloat(num1) - Float.parseFloat(num2);
                    TextResult.setText("계산 결과 :" + result.toString());

                }
            }
        });
        BtnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.trim().equals("")|| num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력 값이 비었습니다",Toast.LENGTH_SHORT)
                            .show();
                }else{
                    result= Float.parseFloat(num1) * Float.parseFloat(num2);
                    TextResult.setText("계산 결과 :" + result.toString());
                }}
        });
        BtnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.trim().equals("")|| num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                            .show();
                }else if(Edit2.getText().toString().equals("0")){
                    Toast.makeText(getApplicationContext(),"0으로 나누면 안됩니다!",Toast.LENGTH_SHORT)
                            .show();
                }else {
                    result= Float.parseFloat(num1) / Float.parseFloat(num2);
                    TextResult.setText("계산 결과 :" + result.toString());

                }
            }
        });
        BtnRm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.trim().equals("")|| num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"입력 값이 비었습니다",Toast.LENGTH_SHORT)
                            .show();
                }else {
                    result= Float.parseFloat(num1) % Float.parseFloat(num2);
                    TextResult.setText("계산 결과 :" + result.toString());
                }
            }
        });



    }
}

