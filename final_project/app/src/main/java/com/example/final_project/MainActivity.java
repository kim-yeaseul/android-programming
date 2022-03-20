package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);

        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int position) {
            return null;

        }

        public long getItemId(int position) {
            return 0;
        }

        Integer[] posterID = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4,
                R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8,
                R.drawable.mov9, R.drawable.mov10, R.drawable.mov1, R.drawable.mov2,
                R.drawable.mov3, R.drawable.mov4, R.drawable.mov5, R.drawable.mov6,
                R.drawable.mov7, R.drawable.mov8, R.drawable.mov9, R.drawable.mov10,
                R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4,
                R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8,
        };


        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 150));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    View dialogView = (View) View.inflate(MainActivity.this,
                            R.layout.big, null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.mvposter);
                    ivPoster.setImageResource(posterID[pos]);

                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.ic_launcher_foreground);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                    return true;
                }
            });
            return imageView;




        }
    }

}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    };

        final int voteCount[] = new int[9];
        for (int i = 0; i <9; i++)
            voteCount[i] = 0;

        ImageView poster[] = new ImageView[9];
        Integer PosterID[] = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4,
                R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8
        };

        final String posterName[] = {"완득이1", "써니1", "괴물1",
                "화려한 외출1", "왕의 남자1", "완득이2", "괴물2", "화려한외출2",
        };

        for (int i = 0; i < PosterID.length; i++) {
            final int index;
            index = i;

            poster[index] = (ImageView) findViewById(PosterID[index]);
            poster[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            posterName[index] + ": 총" + voteCount[index] + "표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnresult);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), resultactivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("posterName", posterName);
                startActivity(intent);
            }
        });
    }
}