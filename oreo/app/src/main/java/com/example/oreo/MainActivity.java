package com.example.oreo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] versionArray = new string[] { "오레오", "파이", "큐(10)"};
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("좋아하는 버전은?");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                button1.setText(versionArray[which]);
            }


        });

        dlg.setPositiveButton("닫기", null);
        dlg.show();

}