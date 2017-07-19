package com.quangduytangcocv2017.dday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rlManHinh;
    private ImageView imvCupid;
    private MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addShow();
        addEven();
    }

    public void addShow() {
        rlManHinh = (LinearLayout) findViewById(R.id.activity_main);
        imvCupid = (ImageView) findViewById(R.id.imvCupid);
    }

    public void addEven() {
        // BackGround
        rlManHinh.setBackgroundResource(R.drawable.coc);

        // Music for Background

        song = MediaPlayer.create(getApplicationContext(), R.raw.nhacnen);
        song.start();

        imvCupid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
        animation.reset();
        imvCupid.clearAnimation();
        imvCupid.startAnimation(animation);
    }

    @Override
    protected void onPause() {
        song.stop();
        super.onPause();
    }
}
