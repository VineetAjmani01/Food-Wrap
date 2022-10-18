package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class restaurantLoginActivity extends AppCompatActivity {

    TextView restautextsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_login);

        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();


        restautextsignup = findViewById(R.id.textView8);

        restautextsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(restaurantLoginActivity.this, RestaurantSignupActivity.class));
            }
        });
    }
}