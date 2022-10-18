package com.vineet.foodwrap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RestaurantDashboardActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationViewRestaurant;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_dashboard);


        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();






        bottomNavigationViewRestaurant= findViewById(R.id.bottomNav);

        bottomNavigationViewRestaurant.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.item1:
                                   getSupportFragmentManager().beginTransaction().replace(R.id.restauranthome, new ResttaurantHomeFragment()).commit();
                        break;
                    case R.id.item2:
                                 getSupportFragmentManager().beginTransaction().replace(R.id.restauranthome, new FeedFragment()).commit();
                        break;

                }
                return true;
            }
        });

    }
}