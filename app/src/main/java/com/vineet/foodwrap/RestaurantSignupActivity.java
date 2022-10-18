package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RestaurantSignupActivity extends AppCompatActivity {

    TextView loginrestaurant;

    Button restaurantdashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_signup);

        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();

        loginrestaurant = findViewById(R.id.textView6);

        restaurantdashboard = findViewById(R.id.button6);

        loginrestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantSignupActivity.this, restaurantLoginActivity.class));
            }
        });


        restaurantdashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantSignupActivity.this, RestaurantDashboardActivity.class));
            }
        });
    }
}