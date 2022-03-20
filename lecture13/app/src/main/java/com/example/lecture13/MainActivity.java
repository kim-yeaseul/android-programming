
package com.example.lecture13;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);

        gv.setAdapter(gAdapter); }
        public class MyGridAdapter extends BaseAdapter {
        Context context; public MyGridAdapter(Context c){ context = c; }
        public int getCount(){ return posterID.length; }

        public Object getItem(int position){ return null;

        }
        public long getItemId(int position){ return 0; }

        Integer[] posterID = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov1, R.drawable.mov2,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov1, R.drawable.mov2, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                 };

        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100,150));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    View dialogView = (View) View.inflate(MainActivity.this,
                            R.layout.dialog, null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);

                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.ic_launcher_foreground);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show(); }
            });

            return imageView;
        }
    }
}




