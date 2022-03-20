package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.web);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);

        web.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.goBack();
            }
        });

    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
 ​

         >activity_main.xml

         -

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".MainActivity"
            android:orientation="vertical">

<LinearLayout
        android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">
<EditText
            android:id="@+id/edtUrl"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="4"
                    android:singleLine="true">
</EditText>
<Button
            android:id="@+id/btnGo"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="이동"/>
<Button
            android:id="@+id/btnBack"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="이전"/>
</LinearLayout>
<WebView
        android:id="@+id/webView1"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:background="#2F4F4F"/>

</LinearLayout>