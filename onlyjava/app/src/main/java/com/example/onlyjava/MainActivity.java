package com.example.onlyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("토스트 연습");

        final Button btn1 = (Button)findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast tMsg = Toast.makeText(MainActivity.this, "토스트 연습",
                        Toast.LENGTH_SHORT);

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yoffset = (int) (Math.random() * display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset,
                        yoffset);
                tMsg.show();
            }
        });
    }
}