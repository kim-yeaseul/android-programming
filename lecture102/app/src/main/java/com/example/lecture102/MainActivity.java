package com.example.lecture102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for (int i = 0; i <9; i++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageID[] = {R.id.gridView1, R.id.img2, R.id.img3,
                R.id.img4,R.id.img5, R.id.img6, R.id.img7, R.id.img8,
                R.id.img9};

        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
        "해변에서"};

        for (int i = 0; i < imageID.length; i++) {
            final int index;
            index = i;

            image[index] = (ImageView) findViewById(imageID[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총" + voteCount[index] + "표",
                            Toast.LENGTH_SHORT).show();
                        }
                    });
                }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("VoteCount", voteCount);
            intent.putExtra("ImageName", imgName);
            startActivity(intent);
            }
        });
    }
}

