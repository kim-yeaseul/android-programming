package com.example.project_5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn;
    TextView tview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT
        );
        LinearLayout baseLayout=new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout,params);

        edt=new EditText(this);
        edt.setHint("여기에 입력하세요");

        baseLayout.addView(edt);

        btn=new Button(this);
        btn.setText("버튼입니다.");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        tview=new TextView(this);
        tview.setTextSize(20);
        tview.setText("텍스트뷰입니다.");
        tview.setTextColor(Color.MAGENTA);
        baseLayout.addView(tview);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                  tview.setText(edt.getText().toString());
                }
        });
    }
}
