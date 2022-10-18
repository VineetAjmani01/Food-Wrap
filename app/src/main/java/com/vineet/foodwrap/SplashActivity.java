package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView t1;
    ImageView iv;
    Animation anim1, anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();

        t1 = findViewById(R.id.textView);
        iv = findViewById(R.id.imageView);

        anim1= AnimationUtils.loadAnimation(this, R.anim.rotate);
        anim2=AnimationUtils.loadAnimation(this, R.anim.blink);

        iv.setAnimation(anim1);
        t1.setAnimation(anim2);

        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, GetStartedActivity.class);
                //    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                startActivity(i);
                finish();


            }
        },3000);
    }
}