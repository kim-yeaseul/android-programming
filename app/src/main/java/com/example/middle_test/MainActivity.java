package com.example.middle_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true; // 입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; // 계산 값 저장
    char operator = '+'; // 연산자 저장

    final String CLEAR_INPUT_TEXT = "0";


    TextView resultText, countText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.TextResult);
        setTitle("계산기");
        

    // AC,  BS 클릭
    public void buttonClick(View Thread view;
        view) {

        switch ( view.getId() )
        {
            case R.id.btnAC:
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUT_TEXT);
                break;


            case R.id.btnBC:
                if (resultText.getText().toString().length() > 1 )
                {
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0,getResultText.length()-1);
                    resultText.setText(subString);
                } else {
                    resultText.setTextColor(0xFF666666);
                    resultText.setText(CLEAR_INPUT_TEXT);
                    isFirstInput = true;
                }
                break;

            default:
                break;

        }
    }

    // 입력된 숫자를 초기화
    public void setClearText(String clearText)
    {
        isFirstInput = true;
        resultText.setTextColor(0xFF666666);
        resultText.setText(clearText);
    }

    // 0~9 버튼 클릭
    public void numButtonClick(View view)
    {
        Button getButton = findViewById(view.getId());

        if(isFirstInput){
            resultText.setTextColor(0xFF000000);
            resultText.setText(getButton.getText().toString());
            isFirstInput = false;
        } else {
            if (resultText.getText().toString().equals("0"))
            {
                Toast.makeText(getApplicationContext(), "초기 입력값이 0입니다.",Toast.LENGTH_LONG).show();
                setClearText(CLEAR_INPUT_TEXT);
                return;
            }
            resultText.append(getButton.getText().toString());
        }
    }



    // 사칙연산 값을 반환
 button1.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            myStr1 = et1.getText().toString();
            myStr2 = et2.getText().toString();
            if(myStr1.isEmpty() || myStr2.isEmpty()){
                Toast.makeText(getApplicationContext(), "하나라도 입력해요", Toast.LENGTH_SHORT).show();
            }else{
                num = Double.parseDouble(myStr1) + Double.parseDouble(myStr2);
                tv.setText("계산 결과 : " + num);
            }
        }
    });

		button2.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            myStr1 = et1.getText().toString();
            myStr2 = et2.getText().toString();
            if(myStr1.isEmpty() || myStr2.isEmpty()){
                Toast.makeText(getApplicationContext(), "하나라도 입력해요", Toast.LENGTH_SHORT).show();
            }else{
                num = Double.parseDouble(myStr1) - Double.parseDouble(myStr2);
                tv.setText("계산 결과 : " + num);
            }
        }
    });

		button3.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            myStr1 = et1.getText().toString();
            myStr2 = et2.getText().toString();
            if(myStr1.isEmpty() || myStr2.isEmpty()){
                Toast.makeText(getApplicationContext(), "하나라도 입력해요", Toast.LENGTH_SHORT).show();
            }else{
                num = Double.parseDouble(myStr1) * Double.parseDouble(myStr2);
                tv.setText("계산 결과 : " + num);
            }
        }
    });

		button4.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            myStr1 = et1.getText().toString();
            myStr2 = et2.getText().toString();
            String zero = "0";
            if(myStr1.isEmpty() || myStr2.isEmpty()){
                Toast.makeText(getApplicationContext(), "하나라도 입력해요", Toast.LENGTH_SHORT).show();
            }else if(myStr2.equals(zero)){
                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
            }else{
                num = Double.parseDouble(myStr1) / Double.parseDouble(myStr2);
                tv.setText("계산 결과 : " + num);
            }
        }
    });

		button5.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            myStr1 = et1.getText().toString();
            myStr2 = et2.getText().toString();
            if(myStr1.isEmpty() || myStr2.isEmpty()){
                Toast.makeText(getApplicationContext(), "하나라도 입력해요", Toast.LENGTH_SHORT).show();
            }else{
                num = Integer.parseInt(myStr1) % Integer.parseInt(myStr2);
                tv.setText("계산 결과 : " + num);
            }
        }
    });
}
}
    // 연산자 클릭
    public void operatorClick(View view)
    {
        Button getButton = findViewById(view.getId());

        if(view.getId() == R.id.btnreseult) {
            if(isFirstInput){
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUT_TEXT);
                // = 두번 이상 누를 때 처리
            } else {
                resultNumber = intCal(resultNumber, Integer.parseInt(resultText.getText().toString()), operator);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
            }

        } else {

            if(isFirstInput){
                operator = getButton.getText().toString().charAt(0);
            } else {
                int lastNum = Integer.parseInt(resultText.getText().toString());
                resultNumber = intCal(resultNumber, lastNum, operator);
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
            }
        }
    }
}