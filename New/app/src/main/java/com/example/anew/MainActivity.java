package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_show,et_result;

    Button add,sub,mul,div,remainder,del;
    Button result;

    //이번 연산의 결과를 저장
    String history = "";
    //피연산자1
    String number1 = "";
    //피연산자2
    String number2 = "";

    //어떤 연산자가 선택되었는지 확인하기 위한 int형 type변수
    int type;

    int ADD = 0;
    int SUB = 1;
    int MUL = 2;
    int DIV = 3;
    int REMAINDER = 4;
    double d1;
    double d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_show = findViewById(R.id.et_show);
        et_result = findViewById(R.id.et_result);
        et_result.setText("");
        add = findViewById(R.id.add_but);
        sub = findViewById(R.id.sub_but);
        mul = findViewById(R.id.mul_btn);
        div = findViewById(R.id.div_btn);
        del = findViewById(R.id.btnBC);

        result = findViewById(R.id.btn_reseult);

        add.setOnClickListener(mListener);
        sub.setOnClickListener(mListener);
        mul.setOnClickListener(mListener);
        div.setOnClickListener(mListener);
        result.setOnClickListener(mListener);
        del.setOnClickListener(mListener);

        //초기화
        Button clear = findViewById(R.id.btnAC);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_show.setText("");
                et_result.setText("");
                d1 = d2 = 0;
                history = number1 = number2 = "";
            }
        });

        Button plus_minus = findViewById(R.id.btn_remainder);
        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //실수인지 정수인지 판단해서 부호 바꾸기
                if( ( (Double.parseDouble(et_result.getText().toString())) - ((int)Double.parseDouble(et_result.getText().toString())) ) == 0.0 )
                {
                    et_result.setText( "" + (Integer.parseInt(et_result.getText().toString()) * -1) );
                }
                else {
                    et_result.setText( "" + (Double.parseDouble(et_result.getText().toString()) * -1) );
                }

            }
        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(et_result.getText().toString() == null)
            {
                Toast.makeText(MainActivity.this,"수를 입력하세요",Toast.LENGTH_SHORT).show();
            }
            switch (v.getId()) {
                case R.id.add_but :
                    number1 = et_result.getText().toString();
                    history = et_result.getText().toString() + " + ";
                    et_show.setText(history);
                    et_result.setText("");

                    type = ADD;
                    break;

                case R.id.sub_but :
                    number1 = et_result.getText().toString();
                    history = et_result.getText().toString() + " - ";
                    et_show.setText(history);
                    et_result.setText("");

                    type = SUB;
                    break;

                case R.id.mul_btn :
                    number1 = et_result.getText().toString();
                    history = et_result.getText().toString() + " * ";
                    et_show.setText(history);
                    et_result.setText("");

                    type = MUL;
                    break;

                case R.id.div_btn :
                    number1 = et_result.getText().toString();
                    history = et_result.getText().toString() + " / ";
                    et_show.setText(history);
                    et_result.setText("");

                    type = DIV;
                    break;

                case R.id.btn_remainder:
                    number1 = et_result.getText().toString();
                    history = et_result.getText().toString() + " % ";
                    et_show.setText(history);
                    et_result.setText("");

                    type = REMAINDER;
                    break;

                case R.id.btnBC :

                    String del_number = et_result.getText().toString();
                    Toast.makeText(MainActivity.this,del_number,Toast.LENGTH_SHORT).show();
                    et_result.setText(del_number.substring(0,del_number.length() - 1));
                    break;

                case R.id.btn_reseult :
                    double result = 0;
                    Toast.makeText(MainActivity.this, "결과", Toast.LENGTH_SHORT).show();
                    number2 = et_result.getText().toString();
                    history = history + et_result.getText().toString();
                    et_show.setText(history);

                    d1 = Double.parseDouble(number1);
                    d2 = Double.parseDouble(number2);

                    if(type == ADD) {
                        result = d1 + d2;
                        et_result.setText("" + result);
                    } else if (type == SUB) {
                        result = d1 - d2;
                        et_result.setText("" + result);
                    }else if (type == MUL) {
                        result = d1 * d2;
                        et_result.setText("" + result);
                    }else if (type == DIV) {
                        result = d1 / d2;
                        et_result.setText("" + result);
                    }else if (type == REMAINDER) {
                        result = d1 % d2;
                        et_result.setText("" + result);
                    }

                    number1 = et_result.getText().toString();
                    break;
            }
        }
    };

    public void onClick (View v)
    {
        switch(v.getId()){
            case R.id.btn0 : et_result.setText(et_result.getText().toString() + 0); break;
            case R.id.num1_but : et_result.setText(et_result.getText().toString() + 1); break;
            case R.id.num2_but : et_result.setText(et_result.getText().toString() + 2); break;
            case R.id.num3_but : et_result.setText(et_result.getText().toString() + 3); break;
            case R.id.num4_but : et_result.setText(et_result.getText().toString() + 4); break;
            case R.id.num5_but : et_result.setText(et_result.getText().toString() + 5); break;
            case R.id.num6_but : et_result.setText(et_result.getText().toString() + 6); break;
            case R.id.num7_but : et_result.setText(et_result.getText().toString() + 7); break;
            case R.id.num8_but : et_result.setText(et_result.getText().toString() + 8); break;
            case R.id.num9_but : et_result.setText(et_result.getText().toString() + 9); break;
            case R.id.btndot : et_result.setText(et_result.getText().toString() + "."); break;
        }
    }
}

