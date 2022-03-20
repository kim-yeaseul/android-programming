package com.example.final_project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class subactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

